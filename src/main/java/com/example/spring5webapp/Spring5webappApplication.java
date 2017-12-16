package com.example.spring5webapp;

import com.example.spring5webapp.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Spring5webappApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Spring5webappApplication.class, args);

        // Request context to provide a bean "myController"
        MyController controller = (MyController) ctx.getBean("myController");

        controller.hello();
    }
}
