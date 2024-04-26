package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverLoad {

    public void loadDrive(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Drivers are not loading...");
        }
    }

    public String connection(String url, String username, String password) {
        String query = "Select * from employee_payroll";
        try {
            java.sql.Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Database Succesfully.");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getDouble(5));
//            }
            rs.close();
            con.close();
            stmt.close();
            System.out.println();
            return "Connection closed succesfully...!";

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
            return "Connection Unsuccesful..!";
        }
    }

    public List<Employee_payroll> listmethod(String url, String username, String password) throws ExceptionClass {
        String query = "Select * from employee_payroll";
        List<Employee_payroll> employeeList = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(query);

            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString(2);
                String phoneNumber = res.getString(3);
                String gender = res.getString(4);
                double salary = res.getDouble(5);
                Employee_payroll emp = new Employee_payroll(id, name, phoneNumber, gender, salary);
                employeeList.add(emp);
            }
        } catch (SQLException e) {
            throw new ExceptionClass("Data is not in the database..");
        }
        return employeeList;
    }


    public int Updatesalary(String url, String username, String password) throws ExceptionClass{
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            String query = "UPDATE employee_payroll \r\n"
                    + "SET basicpay = 300000 \r\n"
                    + "WHERE id = 7";
           int executeUpdate = st.executeUpdate(query);


          return executeUpdate;
        }catch (SQLException e){
            throw new ExceptionClass("Data not updated please check");
        }
    }
}

