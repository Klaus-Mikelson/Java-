package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton b1,b11;
    JComboBox bedtype;
    JCheckBox choose;

    SearchRoom(){
        setLayout(null);

        JLabel l1=new JLabel("Room Search");
        l1.setBounds(400,20,200,30);
        l1.setFont(new Font("serif",Font.BOLD,30));
        l1.setForeground(Color.GRAY);
        add(l1);

        JLabel bed=new JLabel("Select");
        bed.setFont(new Font("mahout",Font.PLAIN,13));
        bed.setBounds(50,90,100,20);
        add(bed);

        String str1[]={"Single","Double"};
        bedtype=new JComboBox(str1);
        bedtype.setBounds(150,90,200,20);
        bedtype.setBackground(Color.white);
        add(bedtype);

        choose=new JCheckBox("Only display available");
        choose.setBounds(700,90,400,20);
        choose.setBackground(Color.white);
        add(choose);


        JLabel l11=new JLabel("Roomno");
        l11.setBounds(90,170,100,30);
        l11.setFont(new Font("serif",Font.BOLD,17));
        add(l11);

        JLabel l2=new JLabel("Price");
        l2.setBounds(400,170,100,30);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);

        JLabel l3=new JLabel("BedType");
        l3.setBounds(650,170,100,30);
        l3.setFont(new Font("serif",Font.BOLD,17));
        add(l3);

        JLabel l4=new JLabel("Availability");
        l4.setBounds(860,170,100,30);
        l4.setFont(new Font("serif",Font.BOLD,17));
        add(l4);

        table=new JTable();
        table.setBounds(60,210,1000,200);
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

        b1=new JButton("Submit");
        b1.setFont(new Font("Serif",Font.BOLD,17));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(250,500,120,30);
        b1.addActionListener(this);
        add(b1);

        b11=new JButton("Back");
        b11.setFont(new Font("Serif",Font.BOLD,17));
        b11.setBackground(Color.black);
        b11.setForeground(Color.white);
        b11.setBounds(600,500,120,30);
        b11.addActionListener(this);
        add(b11);

        getContentPane().setBackground(Color.white);
        setBounds(250,200,1110,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b11){
            setVisible(false);
            new Reception();
        }else{
            try {
                Conn conn=new Conn();
                String query="select * from room where bedtype = '"+bedtype.getSelectedItem()+"'";
                String q2="select * from room where available = 'Vacant' AND bedtype = '"+bedtype.getSelectedItem()+"'";
                ResultSet rs;
                if (choose.isSelected()){
                    rs=conn.s.executeQuery(q2);
                }
                else {
                    rs=conn.s.executeQuery(query);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public static void main(String[] args) {
        new SearchRoom();
    }

}
