package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRoomStats extends JFrame implements ActionListener {
    Choice phone;
    JTextField roomno,price,na,level;
    JButton b1,b2,b3;

    UpdateRoomStats(){
        setLayout(null);

        JLabel head=new JLabel("Update Room Status");
        head.setFont(new Font("mahout",Font.BOLD,25));
        head.setForeground(Color.black);
        head.setBounds(70,30,300,30);
        add(head);

        JLabel select=new JLabel("Contact Id");
        select.setBounds(40,110,100,20);
        select.setFont(new Font("serif",Font.BOLD,17));
        add(select);

        phone=new Choice();
        phone.setBounds(140,110,200,20);
        add(phone);

        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            while (rs.next()){
                phone.add(rs.getString("Custid"));
            }
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        JLabel room=new JLabel("Room No");
        room.setBounds(40,150,100,20);
        room.setFont(new Font("serif",Font.BOLD,17));
        add(room);

        roomno=new JTextField();
        roomno.setBounds(140,150,200,20);
        add(roomno);

        JLabel name=new JLabel("BedType");
        name.setBounds(40,190,100,20);
        name.setFont(new Font("serif",Font.BOLD,17));
        add(name);

        na=new JTextField();
        na.setBounds(140,190,200,20);
        add(na);

        JLabel age=new JLabel("Availability");
        age.setBounds(40,230,100,20);
        age.setFont(new Font("serif",Font.BOLD,17));
        add(age);

        level=new JTextField();
        level.setBounds(140,230,200,20);
        add(level);

        JLabel cost=new JLabel("Price");
        cost.setBounds(40,270,100,20);
        cost.setFont(new Font("serif",Font.BOLD,17));
        add(cost);

        price=new JTextField();
        price.setBounds(140,270,200,20);
        add(price);


        b1=new JButton("Check");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBounds(40,320,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Update");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBounds(160,320,100,30);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBounds(290,320,100,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon img=new ImageIcon(getClass().getResource("icons/update.png"));
        Image i2=img.getImage().getScaledInstance(500,380,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i=new JLabel(i3);
        i.setBounds(300,20,500,380);
        add(i);


        getContentPane().setBackground(Color.white);
        setBounds(350,250,800,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                Conn conn = new Conn();
                String id = phone.getSelectedItem();
                String q = "select * from customer where Custid = '" + id + "'";
                ResultSet resultSet = conn.s.executeQuery(q);
                while(resultSet.next()){
                    roomno.setText(resultSet.getString("roomno"));
                }
                String q2="select * from room where roomno = '"+roomno.getText()+"'";
                ResultSet rs=conn.s.executeQuery(q2);
                while (rs.next()) {
                    na.setText(rs.getString("bedtype"));
                    level.setText(rs.getString("available"));
                    price.setText(rs.getString("price"));
                }
            }catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } else if (e.getSource()==b2) {
            String number= phone.getSelectedItem();
            String room=roomno.getText();
            String name=na.getText();
            String age=level.getText();
            String tcheckin=price.getText();
            try {
                Conn conn=new Conn();
                conn.s.executeUpdate("update room set roomno= '"+room+"', bedtype= '"+name+"', available= '"+tcheckin+"', price ='"+age+"' where Custid= '"+number+"'");
                JOptionPane.showMessageDialog(null,"Changes Updated Successfully");
                setVisible(false);
                new Reception();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else {
            setVisible(false);
            new Reception();
        }

    }
    public static void main(String[] args) {
        new UpdateRoomStats();
    }

}
