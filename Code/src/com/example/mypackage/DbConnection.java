package com.example.mypackage;

import java.sql.*;


public class DbConnection {
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst = null;

    public DbConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
            st = con.createStatement();

        }catch(Exception ex){
            System.out.println("Error: " + ex);
        }
    }
    public void updateData(Account account,int balance){
        try{
            String query = "Update clientdata set balance = " + balance + " where username = "+  "'" + account.getUsername() +"'" ;
            st.executeUpdate(query);
            System.out.println("Updated");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
