package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ExceptionClass {
        String url = "jdbc:mysql://localhost:3306/payroll_services";
        String username = "root";
        String password = "1122";

        DriverLoad dl = new DriverLoad();
        dl.loadDrive(url,username,password);
        String result = dl.connection(url,username,password);
       // System.out.println(result);
        List<Employee_payroll> resultList = dl.listmethod(url,username,password);
        for (Employee_payroll emp : resultList){
            System.out.println("Employee ID is : " + emp.getId() +
                    " Employee Name id : " + emp.getName()+ " Employee Number is : " + emp.getPhoneNumber() +
                    " Employee Gender is : " + emp.getGender() + " Employee salary is : " + emp.getSalary());
        }

//        int executeUpdate = dl.Updatesalary(url,username,password);
//
//        if(executeUpdate>0){
//            System.out.println("Updated succesfully." + executeUpdate + " row(s) affected");
//        }else{
//            System.out.println("Update failed..!");
//        }
          List<Employee_payroll> dateRange = dl.retrieveInfoDaterange(url,username,password);
        System.out.println("Employee Who Joins Date range Between '2024-03-05' and '2024-03-05' are :");
        System.out.println("----------------------------------------------------------------");
        for (Employee_payroll emp : dateRange){
            System.out.println("Employee ID is : " + emp.getId() +
                    " Employee Name id : " + emp.getName()+ " Employee Number is : " + emp.getPhoneNumber() +
                    " Employee Gender is : " + emp.getGender() + " Employee salary is : " + emp.getSalary());
        }

        double result1 = dl.Aggerateoperation(url,username,password);
        System.out.println("sum of salary for gender male is : "+result1);
    }
}