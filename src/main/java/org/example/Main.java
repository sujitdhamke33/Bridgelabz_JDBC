package org.example;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/payroll_services";
        String username = "root";
        String password = "1122";

        DriverLoad dl = new DriverLoad();
        dl.loadDrive(url,username,password);
        String result = dl.connection(url,username,password);
        System.out.println(result);
    }
}