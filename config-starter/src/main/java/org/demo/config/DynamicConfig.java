package org.demo.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamicConfig {

    @Bean
    public DynamicBeanDefinitionRegistrar dynamicBeanDefinitionRegistrar(){
        System.out.println("----------------------------------------");
        return new DynamicBeanDefinitionRegistrar();
    }




}
