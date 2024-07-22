package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton cus,room,depart,totalemp,custominfo,checkout,updatestatus,roomstatus,pickup,searchroom,rooms;
    Reception(){
        setLayout(null);

        cus=new JButton("New Customer");
        cus.setBackground(Color.blue);
        cus.setFont(new Font("serif",Font.PLAIN,17));
        cus.setForeground(Color.white);
        cus.setBounds(30,30,200,30);
        cus.addActionListener(this);
        add(cus);

        room=new JButton("Room Status");
        room.setBackground(Color.blue);
        room.setFont(new Font("serif",Font.PLAIN,17));
        room.setForeground(Color.white);
        room.setBounds(30,70,200,30);
        room.addActionListener(this);
        add(room);

        depart=new JButton("Departments");
        depart.setBackground(Color.blue);
        depart.setFont(new Font("serif",Font.PLAIN,17));
        depart.setForeground(Color.white);
        depart.setBounds(30,110,200,30);
        depart.addActionListener(this);
        add(depart);

        totalemp=new JButton("Employee Info");
        totalemp.setBackground(Color.blue);
        totalemp.setFont(new Font("serif",Font.PLAIN,17));
        totalemp.setForeground(Color.white);
        totalemp.setBounds(30,150,200,30);
        totalemp.addActionListener(this);
        add(totalemp);

        custominfo=new JButton("Customer Info");
        custominfo.setBackground(Color.blue);
        custominfo.setFont(new Font("serif",Font.PLAIN,17));
        custominfo.setForeground(Color.white);
        custominfo.setBounds(30,190,200,30);
        custominfo.addActionListener(this);
        add(custominfo);

        checkout=new JButton("Checkout");
        checkout.setBackground(Color.blue);
        checkout.setFont(new Font("serif",Font.PLAIN,17));
        checkout.setForeground(Color.white);
        checkout.setBounds(30,230,200,30);
        checkout.addActionListener(this);
        add(checkout);

        updatestatus=new JButton("Update Customer info");
        updatestatus.setBackground(Color.blue);
        updatestatus.setFont(new Font("serif",Font.PLAIN,17));
        updatestatus.setForeground(Color.white);
        updatestatus.setBounds(30,270,200,30);
        updatestatus.addActionListener(this);
        add(updatestatus);

        roomstatus=new JButton("Search Room");
        roomstatus.setBackground(Color.blue);
        roomstatus.setFont(new Font("serif",Font.PLAIN,17));
        roomstatus.setForeground(Color.white);
        roomstatus.setBounds(30,310,200,30);
        roomstatus.addActionListener(this);
        add(roomstatus);

        pickup=new JButton("Update Room Status");
        pickup.setBackground(Color.blue);
        pickup.setFont(new Font("serif",Font.PLAIN,17));
        pickup.setForeground(Color.white);
        pickup.setBounds(30,350,200,30);
        pickup.addActionListener(this);
        add(pickup);


        searchroom=new JButton("Logout");
        searchroom.setBackground(Color.blue);
        searchroom.setFont(new Font("serif",Font.PLAIN,17));
        searchroom.setForeground(Color.white);
        searchroom.setBounds(30,390,200,30);
        searchroom.addActionListener(this);
        add(searchroom);

        ImageIcon img=new ImageIcon(getClass().getResource("icons/reception.jpg"));
        Image i2=img.getImage().getScaledInstance(550,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i=new JLabel(i3);
        i.setBounds(260,50,550,400);
        add(i);

        getContentPane().setBackground(Color.white);
        setBounds(350,200,830,530);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cus){
            setVisible(false);
            new AddCustomer();
        } else if (e.getSource()==searchroom) {
            setVisible(false);
        } else if (e.getSource()==room) {
            setVisible(false);
            new RoomStatus();
        } else if (e.getSource()==depart) {
            setVisible(false);
            new Departments();
        } else if (e.getSource()==totalemp) {
            setVisible(false);
            new EmpInfo();
        } else if (e.getSource()==custominfo) {
            setVisible(false);
            new CustomInfo();
        } else if (e.getSource()==roomstatus) {
            setVisible(false);
            new SearchRoom();
        } else if (e.getSource()==updatestatus) {
            setVisible(false);
            new UpdateStats();
        } else if (e.getSource()==pickup) {
            setVisible(false);
            new UpdateRoomStats();
        } else if (e.getSource()==checkout) {
            setVisible(false);
            new Checkout();
        }
    }
    public static void main(String[] args) {
        new Reception();
    }

}
