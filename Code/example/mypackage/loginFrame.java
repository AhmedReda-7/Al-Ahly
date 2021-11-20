package com.example.mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class loginFrame {
    //declare label && Text Fields
    private JFrame logInFrame;
    private JTextField userNameField;
    private JTextField pwdField;
    private JLabel userNameLabel;
    private JLabel pwdLabel;
    private JButton loginBtn;

    // default constructor
    loginFrame(){
        //frame settings
        logInFrame = new JFrame("log in");
        logInFrame.setBounds(200,250,450,300);
        logInFrame.getContentPane().setLayout(null);

        //label& textFields settings

        userNameLabel = new JLabel("User name");
        userNameLabel.setBounds(90,90,80,23);
        logInFrame.getContentPane().add(userNameLabel);

        userNameField = new JTextField();
        userNameField.setBounds(160,90,160,23);
        logInFrame.getContentPane().add(userNameField);

        pwdLabel = new JLabel("password");
        pwdLabel.setBounds(90,120,80,23);
        logInFrame.getContentPane().add(pwdLabel);

        pwdField = new JTextField();
        pwdField.setBounds(160,120,160,23);
        logInFrame.getContentPane().add(pwdField);

        //login Button

        loginBtn = new JButton("Log in");
        loginBtn.setBounds(175,190,80,23);
        Color btnColor = new Color(21,120,233);
        loginBtn.setBackground(btnColor);
        loginBtn.setForeground(Color.white);
        logInFrame.getContentPane().add(loginBtn);


        //Log in button action

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "select * from clientdata where username = " + "'"+ userNameField.getText() + "'" + " AND password = " + "'" + pwdField.getText() + "'";
                    DbConnection qu = new DbConnection();
                    qu.rs = qu.st.executeQuery(query);
                    if(qu.rs.next()){
                            Account account = new Account();
                            account.setUsername(qu.rs.getString("username"));
                            account.setFirstname(qu.rs.getString("firstname"));
                            account.setLastname(qu.rs.getString("lastname"));
                            account.setNationalid(qu.rs.getInt("nationalid"));
                            account.setPhone(qu.rs.getInt("phone"));
                            account.setBalance(qu.rs.getInt("balance"));
                            logInFrame.setVisible(false);
                            Menu menu = new Menu(account);

                    }else{
                        JOptionPane.showMessageDialog(null, "Wrong username or password");
                    }

                } catch (Exception ex){
                   JOptionPane.showMessageDialog(null,ex);
                }
            }
        });

        logInFrame.setVisible(true);



    }








}
