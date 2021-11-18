package com.example.spring_boot;

import com.example.spring_boot.configuration.MyConfig;
import com.example.spring_boot.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

//        SpringApplication.run(Application.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<User> allUsers = communication.getAllUsers();
        System.out.println(allUsers);

        User user = new User(3L, "James", "Brown", (byte)25);
        String one = communication.saveUser(user);

        user.setName("Thomas");
        user.setLastName("Shelby");
        String two = communication.updateUser(user);

        String three = communication.deleteUser(3L);
        System.out.println(one + two + three);
    }

}
