package org.example;

public class Employee_payroll {
    int id;
    String name;
    String phoneNumber ;
    String gender ;
    double salary ;

    public Employee_payroll(int id, String name, String phoneNumber, String gender, double salary) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

}
