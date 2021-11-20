package com.example.mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    Menu(Account account){

        super("Main Menu");
        getContentPane().setLayout(new CardLayout(0,0));
        JPanel Operations = new JPanel();
        getContentPane().add(Operations);
        Operations.setLayout(null);
        Operations.setVisible(true);
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        withdrawButton.setBounds(40,100,100,100);
        depositButton.setBounds(250,100,100,100);
        Operations.add(withdrawButton);
        Operations.add(depositButton);
        JPanel withdrawPanel = new JPanel();
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operations.setVisible(false);
                withdrawPanel.setVisible(true);
            }
        });
        withdrawPanel.setLayout(null);
        getContentPane().add(withdrawPanel);
        JTextField withdrawAmount = new JTextField();
        JButton completeWithdraw = new JButton("OK");
        withdrawAmount.setBounds(100,150,180,20);
        completeWithdraw.setBounds(150,200,70,40);
        withdrawPanel.add(withdrawAmount);
        withdrawPanel.add(completeWithdraw);
        JLabel negativeAmountWithdraw = new JLabel("Please Enter positive amount");
        JLabel notEnough = new JLabel("You do not have enough money");
        negativeAmountWithdraw.setVisible(false);
        notEnough.setVisible(false);
        negativeAmountWithdraw.setBounds(120,200,200,200);
        notEnough.setBounds(120,200,200,200);
        negativeAmountWithdraw.setForeground(Color.RED);
        notEnough.setForeground(Color.RED);
        withdrawPanel.add(negativeAmountWithdraw);
        withdrawPanel.add(notEnough);
        completeWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(withdrawAmount.getText());
                if(amount < 0){
                    notEnough.setVisible(false);
                    negativeAmountWithdraw.setVisible(true);
                }else if(account.getBalance() < amount){
                    negativeAmountWithdraw.setVisible(false);
                    notEnough.setVisible(true);
                }else{
                    account.withdraw(amount);
                    withdrawPanel.setVisible(false);
                    Operations.setVisible(true);
                }
            }
        });
        JPanel depositPanel = new JPanel();
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operations.setVisible(false);
                depositPanel.setVisible(true);
            }
        });
        depositPanel.setLayout(null);
        getContentPane().add(depositPanel);
        JTextField depositAmount = new JTextField();
        JButton completeDeposit = new JButton("OK");
        depositAmount.setBounds(100,150,180,20);
        completeDeposit.setBounds(150,200,70,40);
        depositPanel.add(depositAmount);
        depositPanel.add(completeDeposit);
        JLabel negativeAmountDeposit = new JLabel("Please Enter positive amount");
        negativeAmountDeposit.setVisible(false);
        negativeAmountDeposit.setBounds(120,200,200,200);
        negativeAmountDeposit.setForeground(Color.RED);
        depositPanel.add(negativeAmountDeposit);
        completeDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(depositAmount.getText());
                if(amount < 0) {
                    negativeAmountDeposit.setVisible(true);
                }
                else{
                    account.deposit(amount);
                    depositPanel.setVisible(false);
                    Operations.setVisible(true);
                }
            }
        });
        setSize(400,500);
        setVisible(true);
    }
}
