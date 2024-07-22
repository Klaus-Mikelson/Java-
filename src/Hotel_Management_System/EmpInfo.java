package Hotel_Management_System;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpInfo extends JFrame implements ActionListener {
    JTable table;
    JButton b1;

    EmpInfo(){
        setLayout(null);

        JLabel l1=new JLabel("Employee Details");
        l1.setBounds(300,20,300,50);
        l1.setFont(new Font("serif",Font.BOLD,30));
        l1.setForeground(Color.ORANGE);
        add(l1);

        JLabel l11=new JLabel("Name");
        l11.setBounds(60,90,200,30);
        l11.setFont(new Font("serif",Font.BOLD,17));
        add(l11);

        JLabel l3=new JLabel("Age");
        l3.setBounds(260,90,100,30);
        l3.setFont(new Font("serif",Font.BOLD,17));
        add(l3);

        JLabel l33=new JLabel("Gender");
        l33.setBounds(360,90,100,30);
        l33.setFont(new Font("serif",Font.BOLD,17));
        add(l33);

        JLabel l03=new JLabel("Job");
        l03.setBounds(490,90,200,30);
        l03.setFont(new Font("serif",Font.BOLD,17));
        add(l03);

        JLabel l83=new JLabel("Contact No");
        l83.setBounds(640,90,150,30);
        l83.setFont(new Font("serif",Font.BOLD,17));
        add(l83);

        table=new JTable();
        table.setBounds(60,130,700,200);
        add(table);

        try {
            Conn conn = new Conn();
            ResultSet resultSet=conn.s.executeQuery("select * from employee");
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
        new EmpInfo();
    }

}
