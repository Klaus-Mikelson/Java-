package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton button, button1;

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel user = new JLabel("username");
        user.setBounds(40, 20, 100, 30);
        add(user);

        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);

        JLabel pass = new JLabel("password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);

        button = new JButton("Login");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setBounds(40, 140, 80, 30);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Cancel");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.white);
        button1.setBounds(150, 140, 80, 30);
        button1.addActionListener(this);
        add(button1);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/username.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(450, 30, 200, 200);
        add(img);

        setBounds(350, 250, 700, 350);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String user = username.getText();
            String pass = new String(password.getPassword());
            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet set = c.s.executeQuery(query);
                if (set.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(true);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == button1) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
