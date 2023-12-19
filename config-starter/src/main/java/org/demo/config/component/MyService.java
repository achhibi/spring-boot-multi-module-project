package org.demo.config.component;


import org.springframework.stereotype.Service;


@Service
public class MyService {

    public String get() {
        return "I'm a service from starter";
    }
}
