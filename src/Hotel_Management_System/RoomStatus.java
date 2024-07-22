package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.*;

public class RoomStatus extends JFrame implements ActionListener {
    JTable table;
    JButton b1;

    RoomStatus(){
        setLayout(null);

        JLabel l1=new JLabel("Rooms");
        l1.setBounds(360,20,100,30);
        l1.setFont(new Font("serif",Font.BOLD,30));
        l1.setForeground(Color.magenta);
        add(l1);

        JLabel l11=new JLabel("Roomno");
        l11.setBounds(100,60,100,30);
        l11.setFont(new Font("serif",Font.BOLD,17));
        add(l11);

        JLabel l2=new JLabel("Price");
        l2.setBounds(300,60,100,30);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);

        JLabel l3=new JLabel("BedType");
        l3.setBounds(450,60,100,30);
        l3.setFont(new Font("serif",Font.BOLD,17));
        add(l3);

        JLabel l4=new JLabel("Availability");
        l4.setBounds(600,60,100,30);
        l4.setFont(new Font("serif",Font.BOLD,17));
        add(l4);

        table=new JTable();
        table.setBounds(60,100,700,200);
        add(table);

        try {
            Conn conn = new Conn();
            ResultSet resultSet=conn.s.executeQuery("select * from room");
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
        b1.setBounds(350,400,120,30);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.white);
        setBounds(350,200,830,500);
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
        new RoomStatus();
    }

}
