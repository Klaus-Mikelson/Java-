package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddRoom extends JFrame implements ActionListener {
    JTextField roomn,phonen;
    JComboBox available,bedtype;
    JButton submit,cancel;
    AddRoom(){
        setLayout(null);

        JLabel room=new JLabel("Room No");
        room.setFont(new Font("mahout",Font.PLAIN,17));
        room.setBounds(70,70,100,30);
        add(room);

        roomn=new JTextField();
        roomn.setBounds(170,70,200,30);
        add(roomn);

        JLabel avail=new JLabel("Available");
        avail.setFont(new Font("mahout",Font.PLAIN,17));
        avail.setBounds(70,150,100,30);
        add(avail);

        String str[]={"Select","Vacant","Occupied"};
        available=new JComboBox(str);
        available.setBounds(170,150,200,30);
        available.setBackground(Color.white);
        add(available);

        JLabel bed=new JLabel("Bed");
        bed.setFont(new Font("mahout",Font.PLAIN,17));
        bed.setBounds(70,230,100,30);
        add(bed);

        String str1[]={"Select","Single","Double"};
        bedtype=new JComboBox(str1);
        bedtype.setBounds(170,230,200,30);
        bedtype.setBackground(Color.white);
        add(bedtype);

        JLabel phone=new JLabel("Price");
        phone.setFont(new Font("mahout",Font.PLAIN,17));
        phone.setBounds(70,320,100,30);
        add(phone);

        phonen=new JTextField();
        phonen.setBounds(170,320,200,30);
        add(phonen);

        submit=new JButton("Submit");
        submit.setBounds(150,410,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("tahoma",Font.PLAIN,17));
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(150,450,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("tahoma",Font.PLAIN,17));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon img=new ImageIcon(getClass().getResource("icons/bed.jpeg"));
        Image i2=img.getImage().getScaledInstance(550,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i=new JLabel(i3);
        i.setBounds(420,50,550,400);
        add(i);

       getContentPane().setBackground(Color.white);
        setBounds(250,190,1000,560);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==submit){
            String bed=(String) bedtype.getSelectedItem();
            String avail=(String) available.getSelectedItem();
            String room=roomn.getText();
            String price=phonen.getText();

            try {
                Conn conn=new Conn();
                String query="insert into room values('"+room+"', '"+price+"', '"+bed+"', '"+avail+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Room Added Successfully");
                setVisible(false);
                new Dashboard();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        else {
            setVisible(false);
            new Dashboard();
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }

}
