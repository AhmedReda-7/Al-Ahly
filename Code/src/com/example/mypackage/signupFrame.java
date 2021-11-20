package com.example.mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class signupFrame {
    //declare label && Text Fields
    private JFrame signUpFrame;
    private JTextField userNameField;
    private JTextField pwdField;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField phoneField;
    private JTextField nationalIdField;
    private JLabel userNameLabel;
    private JLabel pwdLabel;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel phoneLabel;
    private JLabel birthDateLabel;
    private JLabel nationalIdLabel;
    private JLabel typeLabel;
    private JButton signUpBtn;
    private JComboBox chooseType;
    // default constructor
    signupFrame(){
        //frame settings
        signUpFrame = new JFrame("Sign up");
        signUpFrame.setBounds(200,250,450,300);
        signUpFrame.getContentPane().setLayout(null);

        //label& textFields settings

        userNameLabel = new JLabel("User name");
        userNameLabel.setBounds(20,10,80,23);
        signUpFrame.getContentPane().add(userNameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(90,10,160,23);
        signUpFrame.getContentPane().add(userNameField);

        pwdLabel = new JLabel("password");
        pwdLabel.setBounds(20,37,80,23);
        signUpFrame.getContentPane().add(pwdLabel);

        pwdField = new JTextField();
        pwdField.setBounds(90,40,160,23);
        signUpFrame.getContentPane().add(pwdField);

        fnameLabel = new JLabel("First name");
        fnameLabel.setBounds(20,70,80,23);
        signUpFrame.getContentPane().add(fnameLabel);

        fnameField = new JTextField();
        fnameField.setBounds(90,70,160,23);
        signUpFrame.getContentPane().add(fnameField);

        lnameLabel = new JLabel("Last name");
        lnameLabel.setBounds(20,100,80,23);
        signUpFrame.getContentPane().add(lnameLabel);

        lnameField = new JTextField();
        lnameField.setBounds(90,100,160,23);
        signUpFrame.getContentPane().add(lnameField);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(20,130,80,23);
        signUpFrame.getContentPane().add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(90,130,160,23);
        signUpFrame.getContentPane().add(phoneField);


        nationalIdLabel = new JLabel("National ID");
        nationalIdLabel.setBounds(20,160,80,23);
        signUpFrame.getContentPane().add(nationalIdLabel);

        nationalIdField = new JTextField();
        nationalIdField.setBounds(90,160,160,23);
        signUpFrame.getContentPane().add(nationalIdField);

        typeLabel = new JLabel("Type");
        typeLabel.setBounds(20,190,80,23);
        signUpFrame.getContentPane().add(typeLabel);

        String [] types = {"normal","VIP"};
        chooseType = new JComboBox(types);
        chooseType.setBounds(90,190,160,23);
        signUpFrame.getContentPane().add(chooseType);
        //signup Button

        signUpBtn = new JButton("Sign UP");
        signUpBtn.setBounds(127,220,80,23);
        Color btnColor = new Color(21,120,233);
        signUpBtn.setBackground(btnColor);
        signUpBtn.setForeground(Color.white);
        signUpFrame.getContentPane().add(signUpBtn);


        //Sign up button action


        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "INSERT INTO `clientdata`(`username`, `password`, `phone`, `firstname`, `lastname`, `nationalid`, `type`) VALUES (? , ? ,? , ? , ? , ?,?)";
                    //object form db connection class to use it's fields
                    DbConnection qu = new DbConnection();
                    qu.pst = qu.con.prepareStatement(query);
                    //every question mark ? in query replaced with number 1 ,2 so on
                    qu.pst.setString(1,userNameField.getText());
                    qu.pst.setString(2,pwdField.getText());
                    qu.pst.setString(3,phoneField.getText());
                    qu.pst.setString(4,fnameField.getText());
                    qu.pst.setString(5,lnameField.getText());
                    qu.pst.setString(6,nationalIdField.getText());
                    qu.pst.setString(7,chooseType.getSelectedItem().toString());

                    //check user name
                    boolean flag = true;
                    try{
                        DbConnection qucheck = new DbConnection();
                        String usernamecheckquery = "SELECT `username` FROM `clientdata` WHERE `username` =  '"+userNameField.getText()+"'";
                        qucheck.rs =qucheck.st.executeQuery(usernamecheckquery);
                        if(qucheck.rs.next()){
                            flag = true;
                        }else
                            flag = false;

                    }catch (Exception x){
                        JOptionPane.showMessageDialog(null,x);

                    }
                    //end of check

                    if(flag == false) {
                        qu.pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Sign up Successfully");
                    }else
                        JOptionPane.showMessageDialog(null,"User name is already taken !!");

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex);
                }
            }});

        signUpFrame.setVisible(true);



    }








}
