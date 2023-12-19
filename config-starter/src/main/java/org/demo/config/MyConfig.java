package org.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
@Configuration
@Slf4j
@EnableConfigurationProperties({ Configurer.class })
//@EnableAspectJAutoProxy
public class MyConfig {


    @Value("${config.key}")
    String key;

    @Bean
    public UUID myBean( Configurer configurer) {

        System.out.printf("key %s%n", key);

        log.info("#################################################################");
        log.info("Creation de myBean : {} {}",                   configurer.name(), configurer.version());
        log.info("#################################################################");
       return UUID.randomUUID();
    }

}