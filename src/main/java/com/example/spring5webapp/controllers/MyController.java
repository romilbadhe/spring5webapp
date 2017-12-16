package com.example.spring5webapp.controllers;


import org.springframework.stereotype.Controller;


// This will act as a bean
@Controller
public class MyController {

    public String hello(){

        System.out.println("Hello");

        return "Hello";
    }
}
