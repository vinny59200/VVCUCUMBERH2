package com.vvauban.bddh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vvauban.bddh2.repository.JokeRepository;

@SpringBootApplication
public class MySpringBootApplication {

    public static void main( String[] args ) {
        SpringApplication.run( MySpringBootApplication.class, args );
    }

}
