
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class cancelTicket {

	JFrame frame = new JFrame("CANCEL TICKET");
	JPanel windowContent = new JPanel();
	JButton ret = new JButton("BACK TO BOOKING PAGE");

	JLabel rtNo = new JLabel("ENTER ROUTE NO.");
	ButtonHandler1 rtListener = new ButtonHandler1();

	JLabel rowNo = new JLabel("ENTER ROW NO. OF YOUR SEAT");

	JLabel colNo = new JLabel("ENTER COLUMN NO. OF YOUR SEAT");

	JTextField inputArea = new JTextField(20); 
	JTextField inputArea2 = new JTextField(20); // FOR ROW NUMBER
	JTextField inputArea3 = new JTextField(20); // FOR COLUMN NUMBER
	JButton confirm = new JButton("CONFIRM");
	String date, rowno, colno;
	JComboBox dateList;
	Combo1 dateListener = new Combo1();
	ButtonHandler1 listener = new ButtonHandler1();
	ButtonHandler2 listener1 = new ButtonHandler2();
	int X, Y;
	String route;
	int row, col;
	private final JDateChooser dateChooser = new JDateChooser();
	private final JLabel lblDate = new JLabel("DATE");

	cancelTicket() {
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = toolKit.getScreenSize();
		X = screenSize.height;
		Y = screenSize.width;
		frame.setVisible(true);
		frame.setSize(X, Y);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		dateChooser.setMaximumSize(new Dimension(50, 20));
		rtNo.setForeground(new Color(0, 128, 0));
		rtNo.setMaximumSize(new Dimension(50, 20));
		rowNo.setForeground(new Color(0, 128, 0));
		rowNo.setMaximumSize(new Dimension(50, 20));
		colNo.setForeground(new Color(0, 128, 0));
		colNo.setMaximumSize(new Dimension(50, 20));
		confirm.setForeground(new Color(0, 0, 255));
		confirm.setMaximumSize(new Dimension(50, 20));
		confirm.addActionListener(listener);
		ret.setForeground(new Color(255, 0, 0));
		ret.addActionListener(listener1);
		windowContent.setBackground(new Color(250, 240, 230));
		lblDate.setForeground(new Color(0, 128, 0));

		windowContent.add(lblDate);

		windowContent.add(dateChooser);
		windowContent.add(rtNo);
		windowContent.add(inputArea);
		windowContent.add(rowNo);
		windowContent.add(inputArea2);
		windowContent.add(colNo);
		windowContent.add(inputArea3);
		windowContent.add(confirm);
		windowContent.add(ret);

		frame.setContentPane(windowContent);
		frame.setVisible(true);
		frame.setBounds(0, 0, 2 * X, Y - 1000);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TPortal\\bus.jpg").getImage());
	}

	private class Combo1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();
			date = (String) cb.getSelectedItem();

		}
	}

	private class ButtonHandler1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int ck;
			route = inputArea.getText();

			try {
				row = Integer.parseInt(inputArea2.getText());
				col = Integer.parseInt(inputArea3.getText());
				if (route.charAt(0) == 'G') {
					ck = BussMod.cancelTicket(route, row, col);
					switch (ck) {
					case 1:
						JOptionPane.showMessageDialog(windowContent, "Invalid Route Number", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						break;
					case 2:
						JOptionPane.showMessageDialog(windowContent, "Seat is not occupied", "ERROR",
								JOptionPane.ERROR_MESSAGE);
						break;
					case 3:
						JOptionPane.showMessageDialog(windowContent, "Ticket Cancelled", "CONFIRMATION",
								JOptionPane.PLAIN_MESSAGE);
						break;
					}
				} else
					JOptionPane.showMessageDialog(windowContent, "Invalid Route Number", "ERROR",
							JOptionPane.PLAIN_MESSAGE);

			} catch (FileNotFoundException ex) {
				Logger.getLogger(cancelTicket.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(cancelTicket.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(cancelTicket.class.getName()).log(Level.SEVERE, null, ex);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(windowContent, "Invalid Row/Column Number", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}
	private class ButtonHandler2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Main ob = new Main();
			frame.dispose();
		}
	}

	public static void main(String[] args) {
		cancelTicket ob = new cancelTicket();
	}
}