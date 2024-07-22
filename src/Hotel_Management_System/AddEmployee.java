package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField user, Age,phoneno;
    JRadioButton male,female;
    JButton submit;
    JComboBox jobs;

    AddEmployee(){
        setLayout(null);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.BOLD,17));
        name.setBounds(60,30,100,30);
        add(name);

        user=new JTextField();
        user.setBounds(160,30,200,30);
        add(user);

        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.BOLD,17));
        age.setBounds(60,100,100,30);
        add(age);

        Age=new JTextField();
        Age.setBounds(160,100,200,30);
        add(Age);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.BOLD,17));
        gender.setBounds(60,170,100,30);
        gender.setBackground(Color.white);
        add(gender);

        male=new JRadioButton("Male");
        male.setFont(new Font("serif",Font.PLAIN,17));
        male.setBackground(Color.white);
        male.setBounds(160,170,100,30);
        add(male);

        female=new JRadioButton("Female");
        female.setFont(new Font("serif",Font.PLAIN,17));
        female.setBackground(Color.white);
        female.setBounds(260,170,100,30);
        add(female);

        ButtonGroup bt=new ButtonGroup();
        bt.add(male);
        bt.add(female);

        JLabel job=new JLabel("Profession");
        job.setFont(new Font("Tahoma",Font.BOLD,17));
        job.setBounds(60,230,100,30);
        job.setBackground(Color.white);
        add(job);

        String str[]={"Select","Goverment","Business/Enterprenuer","Others"};
        jobs=new JComboBox(str);
        jobs.setBounds(160,230,200,30);
        jobs.setBackground(Color.white);
        add(jobs);


        JLabel phone=new JLabel("Contact no");
        phone.setFont(new Font("Tahoma",Font.BOLD,17));
        phone.setBounds(60,290,100,30);
        add(phone);

        phoneno=new JTextField();
        phoneno.setBounds(175,290,100,30);
        add(phoneno);

        submit=new JButton("SUBMIT");
        submit.setBounds(150,390,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("tahoma",Font.PLAIN,17));
        submit.addActionListener(this);
        add(submit);

        ImageIcon img=new ImageIcon(getClass().getResource("icons/staff.jpg"));
        Image i2=img.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i=new JLabel(i3);
        i.setBounds(380,60,400,400);
        add(i);

        getContentPane().setBackground(Color.white);
        setBounds(350,190,850,540);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = user.getText();
        String age = Age.getText();
        String phone = phoneno.getText();
        String gender;
        if (male.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String job= (String) jobs.getSelectedItem();

        try {
            Conn conn=new Conn();
            String query="insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"' , '"+phone+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Added");
            setVisible(false);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }
    public static void main(String[] args) {
        new AddEmployee();
    }

}
