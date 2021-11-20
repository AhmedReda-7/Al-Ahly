package com.example.mypackage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcomeframe extends JFrame {
    private JFrame welcomeFrame;
    private JLabel welcomelabel;
    private Color bcgcolor;
    private JButton singupButton;
    private JButton loginButton;

    welcomeframe(){
        //frame
        welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setBounds(200,250,450,300);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.getContentPane().setLayout(null);

        Color btnColor = new Color(21,120,233);

        singupButton = new JButton("Sign UP");
        singupButton.setBounds(127,90,80,23);
        singupButton.setBackground(btnColor);
        singupButton.setForeground(Color.white);
        welcomeFrame.getContentPane().add(singupButton);

        singupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new signupFrame();
            }
        });

        loginButton = new JButton("Log in");
        loginButton.setBounds(250,90,80,23);
        loginButton.setBackground(btnColor);
        loginButton.setForeground(Color.white);
        welcomeFrame.getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new loginFrame();
            }
        });


        welcomeFrame.setVisible(true);
    }

    protected void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawString("WELCOME",20,20);
    }

}
