package org.test;

import org.demo.config.annotations.DynamicBean;
import org.demo.config.annotations.EnableMyConfig;
import org.demo.config.component.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableMyConfig(value = {String.class, Integer.class})
@DynamicBean(types = String.class)
public class App {
    @Autowired
    MyService service;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }



    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            System.out.printf("In CommandLineRunnerImpl %s", service.get());


        };
    }
}
