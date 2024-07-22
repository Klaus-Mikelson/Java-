package Hotel_Management_System;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomInfo extends JFrame implements ActionListener {
    JTable table;
    JButton b1;

    CustomInfo(){
        setLayout(null);

        JLabel l1=new JLabel("Customer Details");
        l1.setBounds(450,20,300,50);
        l1.setFont(new Font("serif",Font.BOLD,30));
        l1.setForeground(Color.red);
        add(l1);

        JLabel l11=new JLabel("Name");
        l11.setBounds(100,90,200,30);
        l11.setFont(new Font("serif",Font.BOLD,17));
        add(l11);

        JLabel l3=new JLabel("Age");
        l3.setBounds(230,90,100,30);
        l3.setFont(new Font("serif",Font.BOLD,17));
        add(l3);

        JLabel l33=new JLabel("Contact Info");
        l33.setBounds(320,90,100,30);
        l33.setFont(new Font("serif",Font.BOLD,17));
        add(l33);

        JLabel l03=new JLabel("Gender");
        l03.setBounds(440,90,200,30);
        l03.setFont(new Font("serif",Font.BOLD,17));
        add(l03);

        JLabel l83=new JLabel("Identity");
        l83.setBounds(560,90,150,30);
        l83.setFont(new Font("serif",Font.BOLD,17));
        add(l83);

        JLabel l=new JLabel("Room Stay");
        l.setBounds(700,90,150,30);
        l.setFont(new Font("serif",Font.BOLD,17));
        add(l);

        JLabel l2=new JLabel("Time of Checkin");
        l2.setBounds(810,90,150,30);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);

        JLabel l22=new JLabel("Customer Id");
        l22.setBounds(950,90,150,30);
        l22.setFont(new Font("serif",Font.BOLD,17));
        add(l22);

        table=new JTable();
        table.setBounds(60,130,1000,200);
        add(table);

        try {
            Conn conn = new Conn();
            ResultSet resultSet=conn.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        b1=new JButton("Back");
        b1.setFont(new Font("Serif",Font.BOLD,17));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(490,400,120,30);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.white);
        setBounds(250,200,1110,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            setVisible(false);
            new Reception();
        }
    }



    public static void main(String[] args) {
        new CustomInfo();
    }

}

