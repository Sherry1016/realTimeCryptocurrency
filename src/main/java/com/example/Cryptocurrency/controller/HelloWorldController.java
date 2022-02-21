package com.example.Cryptocurrency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String Hello(){
        System.out.println("In controller class and print out hello world");
        return "Hello world";
    }


}
