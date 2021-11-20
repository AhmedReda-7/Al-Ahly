package com.example.mypackage;

public class Account {
    DbConnection connect = new DbConnection();
    private String username;
    private int phone;
    private String firstname;
    private String lastname;
    private int nationalid;
    private int balance;

    public DbConnection getConnect() {
        return connect;
    }

    public String getUsername() {
        return username;
    }

    public int getPhone() {
        return phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getNationalid() {
        return nationalid;
    }

    public int getBalance() {
        return balance;
    }

    public void setConnect(DbConnection connect) {
        this.connect = connect;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNationalid(int nationalid) {
        this.nationalid = nationalid;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount){
        balance-=amount;
        connect.updateData(this,balance);
    }

    public void deposit(int amount){
        balance+=amount;
        connect.updateData(this,balance);
    }
}