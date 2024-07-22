package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    JComboBox identity;
    JTextField user,phoneno,Age,custid;
    JRadioButton male,female;
    Choice croom;
    JLabel time;
    JButton add,cancel;


    AddCustomer() {
        setLayout(null);

        JLabel cust=new JLabel("Customer Forum");
        cust.setFont(new Font("serif",Font.PLAIN,30));
        cust.setForeground(Color.blue);
        cust.setBounds(300,20,300,30);
        add(cust);

        JLabel id=new JLabel("Identity");
        id.setFont(new Font("Tahoma",Font.BOLD,15));
        id.setBounds(20,80,100,20);
        add(id);

        String str[]={"Select","Passport","Aaddhar","PAN","Driving License","OtherId"};
        identity=new JComboBox(str);
        identity.setBounds(150,80,200,20);
        identity.setBackground(Color.white);
        add(identity);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        name.setBounds(20,120,100,30);
        add(name);

        user=new JTextField();
        user.setBounds(150,120,200,30);
        add(user);

        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.BOLD,15));
        age.setBounds(20,170,100,30);
        add(age);

        Age=new JTextField();
        Age.setBounds(150,170,200,30);
        add(Age);

        JLabel Custid=new JLabel("Customer ID");
        Custid.setFont(new Font("Tahoma",Font.BOLD,15));
        Custid.setBounds(20,220,100,30);
        add(Custid);

        custid=new JTextField();
        custid.setBounds(150,220,200,30);
        add(custid);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.BOLD,15));
        gender.setBounds(20,270,100,30);
        gender.setBackground(Color.white);
        add(gender);

        male=new JRadioButton("Male");
        male.setFont(new Font("serif",Font.PLAIN,15));
        male.setBackground(Color.white);
        male.setBounds(150,270,100,30);
        add(male);

        female=new JRadioButton("Female");
        female.setFont(new Font("serif",Font.PLAIN,15));
        female.setBackground(Color.white);
        female.setBounds(250,270,100,30);
        add(female);

        ButtonGroup bt=new ButtonGroup();
        bt.add(male);
        bt.add(female);

        JLabel alloroom=new JLabel("Room No ");
        alloroom.setFont(new Font("Tahoma",Font.BOLD,15));
        alloroom.setBounds(20,320,100,30);
        add(alloroom);

        croom=new Choice();
        croom.setBounds(150,320,200,30);
        add(croom);

        try {
            Conn conn = new Conn();
            String query = "select * from room where available= 'Vacant'";
            ResultSet resultSet = conn.s.executeQuery(query);
            boolean roomsAvailable = false;
            while (resultSet.next()) {
                    croom.add(resultSet.getString("roomno"));
                     roomsAvailable = true;
            }
            if (!roomsAvailable) {
                croom.add("No Room available");
            }
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

       JLabel checktime=new JLabel("Checkin Time");
       checktime.setFont(new Font("Tahoma",Font.BOLD,15));
       checktime.setBounds(20,360,120,30);
       add(checktime);

       Date date=new Date();
       time=new JLabel(""+date);
       time.setFont(new Font("Tahoma",Font.BOLD,15));
       time.setBounds(150,360,210,30);
       add(time);

        JLabel phone=new JLabel("Contact no");
        phone.setFont(new Font("Tahoma",Font.BOLD,15));
        phone.setBounds(20,400,100,30);
        add(phone);

        phoneno=new JTextField();
        phoneno.setBounds(150,400,200,30);
        add(phoneno);

       add=new JButton("ADD");
       add.setBounds(50,450,120,30);
       add.setForeground(Color.white);
       add.setBackground(Color.black);
       add.addActionListener(this);
       add(add);

       cancel=new JButton("Cancel");
       cancel.setBounds(190,450,120,30);
       cancel.setForeground(Color.white);
       cancel.setBackground(Color.black);
       cancel.addActionListener(this);
       add(cancel);

        ImageIcon img=new ImageIcon(getClass().getResource("icons/customer.png"));
        Image i2=img.getImage().getScaledInstance(450,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i=new JLabel(i3);
        i.setBounds(380,50,450,400);
        add(i);

        getContentPane().setBackground(Color.white);
        setBounds(350,190,850,550);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==add){
            String name=user.getText();
            String age=Age.getText();
            String phone=phoneno.getText();
            String cus=custid.getText();
            String gen;
            if (male.isSelected()){
                gen="Male";
            }
            else {
                gen="Female";
            }
            String id= (String) identity.getSelectedItem();
            String choice=croom.getSelectedItem();
            String t=time.getText();

            try{
            Conn conn=new Conn();
            String query="insert into customer values('"+name+"', '"+age+"', '"+phone+"', '"+gen+"', '"+id+"', '"+choice+"', '"+t+"', '"+cus+"')";
            String query2="update room set available = 'Occupied' where roomno = '"+choice+"'";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null,"Added Successfully to database");
            setVisible(false);
            new Reception();

            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        else {
            setVisible(false);
            new Reception();
        }
    }


    public static void main(String[] args) {
        new AddCustomer();
    }

}
