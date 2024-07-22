package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagement extends JFrame implements ActionListener {
    HotelManagement(){
        setSize(1366, 600);
        setLocation(100, 100);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 600); //layout of frame
        add(image);

        JLabel text=new JLabel("Hotel Management System");
        text.setBounds(30,490,600,70);
        text.setFont(new Font("serif",Font.BOLD,50));
        text.setForeground(Color.white);
        image.add(text);

        JButton jButton=new JButton("Next");
        jButton.setBounds(1000,500,200,50);
        jButton.setForeground(Color.orange);
        jButton.setBackground(Color.black);
        jButton.setFont(new Font("serif",Font.BOLD,40));
        jButton.addActionListener(this);
        image.add(jButton);


        setVisible(true);
        while (true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          setVisible(false);
          new Login();
    }
    public static void main(String[] args) {
        new HotelManagement();
    }
}
