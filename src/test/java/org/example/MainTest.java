package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverLoadTest {
    String url = "jdbc:mysql://localhost:3306/payroll_services";
    String username = "root";
    String password = "1122";
    DriverLoad dl;
    public DriverLoadTest(){
        dl  = new DriverLoad();
    }
    @Test
    void connection() {
        String result =  dl.connection(url,username,password);
        System.out.println(result);
        Assertions.assertEquals("Connection closed succesfully...!",result);
    }
    @Test
    void listmethod() throws ExceptionClass{
      List<Employee_payroll> result = dl.listmethod(url,username,password);
      Employee_payroll emp = result.get(0);
      Assertions.assertEquals(1,emp.getId());
      Assertions.assertEquals("sujit",emp.getName());
      Assertions.assertEquals("1234",emp.getPhoneNumber());
      Assertions.assertEquals("M",emp.getGender());
      Assertions.assertEquals(26000.0,emp.getSalary());
    }
}