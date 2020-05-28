package com.letsgeeks.udemy.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String args[]){
        String jdbcUrl  = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=EST";
        String username = "hbstudent";
        String password = "hbstudent";
        try{
            System.out.println("Connecting to the Database :"+jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("Connection is Sucessful");
        }catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
