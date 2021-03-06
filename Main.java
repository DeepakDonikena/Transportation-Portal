
import java.awt.Container;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class Main extends JFrame {
	String svar; // Variable to record the source data
	String dvar; // Variable to record the destination data

	JTextField inputDate = new JTextField("ENTER DATE IN DD-MM-YYYY", 20); // TO INPUT DATE

	JButton confirm = new JButton("Book Ticket");
	JButton cancel = new JButton("Cancel Ticket");
	JButton admin = new JButton("Login as Admin");
	JLabel lab = new JLabel("WELCOME TO TRANSPORTATION PORTAL");
	Choice ch = new Choice();
	JLabel l1 = new JLabel("Source");
	JLabel l2 = new JLabel("Destination");
	Choice ch2 = new Choice();
	JPanel windowContent;
	ButtonHandler listener = new ButtonHandler();
	ButtonHandler1 listener4 = new ButtonHandler1();
	ButtonHandler2 listener5 = new ButtonHandler2();
	String date;
	JFrame frame = new JFrame("WELCOME PAGE");
	JComboBox patternList;
	Combo listener1 = new Combo(); 
	JComboBox list2; 
	Combo1 listener2 = new Combo1(); 
	JPanel j1 = new JPanel();
	JPanel j2 = new JPanel();
	JPanel j3 = new JPanel();
	JPanel j4 = new JPanel();
	JComboBox dateList;
	Combo2 listener3 = new Combo2();

	Main() {
		int X, Y;
		Point p;

		Toolkit toolKit = Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = toolKit.getScreenSize();
		toolKit.getScreenSize();
		X = screenSize.height;
		Y = screenSize.width;
		frame.getMaximizedBounds();
		confirm.setForeground(new Color(255, 0, 0));

		confirm.addActionListener(listener);
		cancel.setForeground(new Color(255, 0, 0));
		cancel.addActionListener(listener4);
		admin.setForeground(new Color(0, 0, 255));
		admin.addActionListener(listener5);
		lab.setBounds(0, 0, X, Y);
		windowContent = new JPanel();
		windowContent.setLayout(new FlowLayout());
		j1.setLayout(new FlowLayout());
		j2.setBackground(new Color(250, 240, 230));
		j2.setLayout(new FlowLayout());
		lab.setForeground(new Color(0, 0, 255));
		lab.setFont(new Font("Serif", Font.BOLD, 18));

		windowContent.add(lab);
		l1.setForeground(new Color(0, 128, 0));
		j2.add(l1);
		lab.setBounds(X, 100, 20, 20);
		lab.setBounds(200, 10, 80, 80);

		String[] patternExamples = { "--Select--", "Toronto", "Brampton", "Missisaauga", "Ottawa", "Montreal" };
		svar = patternExamples[0];
		patternList = new JComboBox(patternExamples);
		patternList.setEditable(true);
		patternList.addActionListener(listener1);
		// For the second JCOMBO BOX,destination
		String[] patternExamples1 = { "--Select--", "Toronto", "Brampton", "Missisaauga", "Ottawa", "Montreal" };

		String[] dateExamples = new String[62];
		int k;
		int i;
		dateExamples[0] = "---Select---" ;
		
		for (i = 1; i < 30; i++) {
			k = i + 1;
			dateExamples[i] = k + " APR" + " 2019";
		}
		for (int j = 0; j < 31; j++) {
			k = j + 1;
			dateExamples[i] = k + " MAY" + " 2019";
			++i;
		}
		// for date
		date = dateExamples[0];
		dateList = new JComboBox(dateExamples);
		dateList.setEditable(false);
		dateList.addActionListener(listener3);
		dvar = patternExamples1[0];

		list2 = new JComboBox(patternExamples1);
		list2.setEditable(true);
		list2.addActionListener(listener2);

		j2.add(patternList);
		l2.setForeground(new Color(0, 128, 0));
		j2.add(l2);
		j2.add(list2);
		j2.add(dateList);

		j1.add(confirm);
		j1.add(cancel);
		j1.add(admin);

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(windowContent, BorderLayout.NORTH);
		frame.getContentPane().add(j2, BorderLayout.CENTER);
		frame.getContentPane().add(j1, BorderLayout.SOUTH);
		frame.setSize(X / 2, Y / 2);
		frame.setVisible(true);// to display the frame
		frame.setBounds(0, 0, X, Y - 1000);
		frame.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TPortal\\bus.jpg").getImage());
	}
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (svar.equals(dvar))

					JOptionPane.showMessageDialog(windowContent, "SOURCE AND DESTINATION CANNOT BE SAME", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				else {
					Page2 ob = new Page2(svar, dvar, date);
					frame.dispose();
				}
			} catch (IOException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	private class Combo implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JComboBox cb = (JComboBox) e.getSource();
			svar = (String) cb.getSelectedItem();
		}
	}
	private class Combo1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();
			dvar = (String) cb.getSelectedItem();

		}
	}
	private class Combo2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();
			date = (String) cb.getSelectedItem();
		}
	}
	private class ButtonHandler1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cancelTicket ob = new cancelTicket();
			frame.dispose();
		}
	}

	private class ButtonHandler2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			admin ob = new admin();
			frame.dispose();
		}
	}
}