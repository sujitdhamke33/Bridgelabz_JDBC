package org.example;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverLoad {

    public void loadDrive(String url, String username, String password) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Drivers are not loading...");
        }
    }

    public String connection(String url, String username, String password) {
        String query = "Select * from employee_payroll";
        try{
            java.sql.Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to Database Succesfully.");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+ " "+rs.getString(3)+ " "+rs.getString(4)+ " "+rs.getDouble(5));
            }
            rs.close();
            con.close();
            stmt.close();
            System.out.println();
            return "Connection closed succesfully...!";

        }catch (
                SQLException e){
            System.out.println(e.getMessage());
            return "Connection Unsuccesfil..!";
        }
    }
}


