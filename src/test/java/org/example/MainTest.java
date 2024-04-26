package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}