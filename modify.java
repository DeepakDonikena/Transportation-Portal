import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class modify {

	int X, Y;
	int flag = 0;
	JFrame frame = new JFrame("MODIFY BUS DETAILS");
	JPanel windowContent = new JPanel();

	JButton uniq = new JButton("ENTER UNIQUE KEY");
	ButtonHandler1 listener1 = new ButtonHandler1();
	String key;

	JButton modType = new JButton("MODIFY BUS TYPE");
	ButtonHandler2 listener2 = new ButtonHandler2();

	String finalType;// the type of the bus after modification

	JButton modsTime = new JButton("MODIFY BUS START TIME");
	ButtonHandler3 listener3 = new ButtonHandler3();

	String finalsTime;// the start time of the bus after modification

	JButton modeTime = new JButton("MODIFY BUS END TIME");
	ButtonHandler4 listener4 = new ButtonHandler4();

	String finaleTime;

	JButton modPrice = new JButton("MODIFY TICKET PRICE");
	ButtonHandler5 listener5 = new ButtonHandler5();

	String finalPrice;
	int price;

	JButton viewFinal = new JButton("DISPLAY MODIFIED DETAILS");
	ButtonHandler6 listener6 = new ButtonHandler6();
	JButton backbut = new JButton("Back");
	ButtonHandler7 butlistener = new ButtonHandler7();

	modify() {

		Toolkit toolKit = Toolkit.getDefaultToolkit();
		java.awt.Dimension screenSize = toolKit.getScreenSize();
		X = screenSize.height;
		Y = screenSize.width;
		frame.setVisible(true);
		frame.setSize(X, Y);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		uniq.setForeground(new Color(0, 128, 0));

		uniq.addActionListener(listener1);
		modType.setForeground(new Color(0, 128, 0));
		modType.addActionListener(listener2);
		modsTime.setForeground(new Color(0, 128, 0));
		modsTime.addActionListener(listener3);
		modeTime.setForeground(new Color(0, 128, 0));
		modeTime.addActionListener(listener4);
		modPrice.setForeground(new Color(0, 128, 0));
		modPrice.addActionListener(listener5);
		viewFinal.setForeground(new Color(0, 128, 0));
		viewFinal.addActionListener(listener6);
		backbut.setForeground(new Color(255, 0, 0));
		backbut.addActionListener((ActionListener) butlistener);
		windowContent.setForeground(new Color(253, 245, 230));

		windowContent.setLayout(new BoxLayout(windowContent, BoxLayout.PAGE_AXIS));

		windowContent.add(uniq);
		windowContent.add(Box.createRigidArea(new Dimension(Y, 40)));
		windowContent.add(modType);
		windowContent.add(Box.createRigidArea(new Dimension(Y, 40)));
		windowContent.add(modsTime);
		windowContent.add(Box.createRigidArea(new Dimension(Y, 40)));
		windowContent.add(modeTime);
		windowContent.add(Box.createRigidArea(new Dimension(Y, 40)));
		windowContent.add(modPrice);
		windowContent.add(Box.createRigidArea(new Dimension(Y, 40)));
		windowContent.add(Box.createRigidArea(new Dimension(Y, 40)));
		windowContent.add(viewFinal);
		windowContent.add(backbut);

		frame.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TransportationPortal1\\bus.jpg").getImage());
		frame.setContentPane(windowContent);
		frame.setVisible(true);
		frame.setSize(X, Y);
		frame.setBounds(0, 0, X, Y-800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private class ButtonHandler1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				key = (String) JOptionPane.showInputDialog(windowContent, "ENTER THE UNIQUE KEY", "INPUT UNIQUE KEY",
						JOptionPane.PLAIN_MESSAGE, null, null, "");
			} catch (NullPointerException t) {
				JOptionPane.showMessageDialog(windowContent, "PLEASE INPUT THE KEY");
			}

		}
	}

	private class ButtonHandler2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] possibilities = { "AC", "SLEEPER", "VOLVO" };
			finalType = (String) JOptionPane.showInputDialog(windowContent, "MODIFY BUS TYPE", "ENTER",
					JOptionPane.PLAIN_MESSAGE, null, possibilities, "");

		}
	}

	private class ButtonHandler3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				finalsTime = (String) JOptionPane.showInputDialog(windowContent, "ENTER THE NEW START TIME", "ENTER",
						JOptionPane.PLAIN_MESSAGE, null, null, "");
			} catch (NullPointerException w) {
				JOptionPane.showMessageDialog(windowContent, "PLEASE INPUT THE START TIME");
			}
		}
	}

	private class ButtonHandler4 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				finaleTime = (String) JOptionPane.showInputDialog(windowContent, "ENTER THE NEW END TIME", "ENTER",
						JOptionPane.PLAIN_MESSAGE, null, null, "");
			} catch (NullPointerException x) {
				JOptionPane.showMessageDialog(windowContent, "PLEASE INPUT THE END TIME");
			}
		}
	}

	private class ButtonHandler5 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				finalPrice = (String) JOptionPane.showInputDialog(windowContent, "ENTER THE NEW PRICE", "ENTER",
						JOptionPane.PLAIN_MESSAGE, null, null, "");
				price = Integer.parseInt(finalPrice);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(windowContent, "Invalid Entry,Please enter again");
			}
		}
	}

	private class ButtonHandler6 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			NullPointerException q = new NullPointerException();

			boolean success = false;

			if (key.charAt(0) == 'G') {
				try {

					if (finalsTime.length() == 0)
						throw q;
					if (finaleTime.length() == 0)
						throw q;
					success = modtrySug(key);
				} catch (IOException ex) {
					Logger.getLogger(modify.class.getName()).log(Level.SEVERE, null, ex);
				} catch (ClassNotFoundException ex) {
					Logger.getLogger(modify.class.getName()).log(Level.SEVERE, null, ex);
				} catch (StringIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(windowContent,
							"PLEASE ENTER A NON-NULL VALUE FOR KEY AND PRESS CONFIRM");
				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(windowContent,
							"PLEASE ENTER NON NULL VALUES FOR START TIME AND END TIME AND PRESS CONFIRM");
				}
			}

			else {
				JOptionPane.showMessageDialog(windowContent, "PLEASE ENTER A STRING STARTING FROM  'G' ");
			}

			String disp = "BUS KEY: " + key + "BUS TYPE: " + finalType + "\n" + "BUS START TIME: " + finalsTime + "\n"
					+ "BUS END TIME: " + finaleTime + "\n" + "TICKET PRICE: " + finalPrice;
			if (success) {
				JOptionPane.showMessageDialog(windowContent, disp, "MODIFIED BUS DETAILS", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	private class ButtonHandler7 implements ActionListener {
		// String newSelection;
		@Override
		public void actionPerformed(ActionEvent e) {
			adminMenu ob = new adminMenu("");
			frame.dispose();
		}
	}

	public boolean modtrySug(String uniq) throws IOException, ClassNotFoundException {

		FileInputStream f = new FileInputStream("Greyhound.dat");
		ObjectInputStream objectinput = new ObjectInputStream(f);
		ArrayList<GreyHound> read = (ArrayList<GreyHound>) objectinput.readObject();
		objectinput.close();
		boolean exists = false;
		for (int i = 0; i < read.size(); i++) {
			if (uniq.equalsIgnoreCase(read.get(i).key)) {
				exists = true;
				flag = 1;
				read.get(i).typechange(finalType);
				read.get(i).starttimechange(finalsTime);
				read.get(i).endtimechange(finaleTime);
				read.get(i).pricechange(price);
				// System.out.println("Found the bus");

				break;
			}
		}
		System.out.println(read.get(0).starttime);

		ArrayList<String> keyList = new ArrayList<>();

		for (int i = 0; i < read.size(); i++) {
			keyList.add(read.get(i).key);
		}

		String disp = "";

		for (int i = 0; i < read.size(); i++) {
			disp = disp + keyList.get(i);
			disp = disp + " ";
		}

		if (!exists) {
			JOptionPane.showMessageDialog(windowContent,
					"PLEASE ENTER A KEY OF A BUS WHICH EXISTS AND THEN PRESS CONFIRM");

			JOptionPane.showMessageDialog(windowContent, disp, "KEY LIST", JOptionPane.INFORMATION_MESSAGE);

		}

		OutputStream file2 = new FileOutputStream("Greyhound.dat");
		OutputStream buffer2 = new BufferedOutputStream(file2);
		ObjectOutput output2 = new ObjectOutputStream(buffer2);

		output2.writeObject(read);

		output2.close();

		if (!exists)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		modify ob = new modify();
	}
}