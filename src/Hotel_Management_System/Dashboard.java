package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard(){

        ImageIcon i1=new ImageIcon(getClass().getResource("icons/dashboard.jpg"));
        Image i2=i1.getImage().getScaledInstance(1980,1080, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1980,1080);
        add(img);

        JLabel text=new JLabel("The Taj Group Welcomes You");
        text.setBounds(400,80,1000,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma",Font.PLAIN,52));
        img.add(text);

        JMenuBar menuBar=new JMenuBar();
        menuBar.setBounds(0,0,1980,31);
        img.add(menuBar);

        JMenu management=new JMenu("Management");
        management.setForeground(Color.red);
        menuBar.add(management);

        JMenu admin=new JMenu("Admin");
        admin.setForeground(Color.blue);
        menuBar.add(admin);

        JMenuItem reception=new JMenuItem("Reception");
        reception.addActionListener(this);
        management.add(reception);

        JMenuItem addemp=new JMenuItem("AddEmployee");
        addemp.addActionListener(this);
        admin.add(addemp);

        JMenuItem addroom=new JMenuItem("AddRoom");
        addroom.addActionListener(this);
        admin.add(addroom);


        setBounds(0,0,1980,1080);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("AddEmployee")){
            new AddEmployee();
        } else if (e.getActionCommand().equals("AddRoom")) {
            new AddRoom();
        } else if (e.getActionCommand().equals("Reception")) {
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }

}
