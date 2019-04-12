//Admin functions
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.GridBagConstraints;

class admin 
{
    JFrame frame = new JFrame("WELCOME TO ADMIN LOGIN");
    JPanel windowContent = new JPanel();
    int X, Y;
    JLabel name = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JTextField username = new JTextField(20);
    JPasswordField passwd = new JPasswordField(20);
    JButton login = new JButton("Login");
    ButtonHandler listener = new ButtonHandler();
    JButton backbut = new JButton("Back");
    ButtonHandler1 butlistener = new ButtonHandler1();

    admin()
    {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        java.awt.Dimension screenSize =
                toolKit.getScreenSize();
        X = screenSize.height;
        Y = screenSize.width;
        frame.setVisible(true);
        frame.setBounds(0,0,X/2,Y-1000);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TPortal\\bus.jpg").getImage());

        login.addActionListener(listener);
        backbut.addActionListener(butlistener);
        windowContent.setBackground(new Color(250, 240, 230));

        windowContent.setLayout(new FlowLayout());
        name.setForeground(new Color(0, 128, 0));

        windowContent.add(name);
        windowContent.add(username);
        password.setForeground(new Color(0, 128, 0));
        windowContent.add(password);
        windowContent.add(passwd);
        windowContent.add(login);
        windowContent.add(backbut);

        frame.setContentPane(windowContent);
        frame.setVisible(true);
       frame.setBounds(0,0,X,Y-1000);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private class ButtonHandler implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (username.getText().equalsIgnoreCase("ADMIN")) {
                if (passwd.getText().equals("123456")) {
                    adminMenu ob = new adminMenu("GREYHOUND");
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(windowContent, "Incorrect Password", "PASSWORD ERROR", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(windowContent, "Incorrect Username or Password", "ERROR", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    private class ButtonHandler1 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           Main ob=new Main();
          frame.dispose();
        }
    }  
}