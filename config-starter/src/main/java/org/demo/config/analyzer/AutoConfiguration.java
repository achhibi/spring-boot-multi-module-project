package org.demo.config.analyzer;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ConfigWithException.class)
public class AutoConfiguration {
    public AutoConfiguration(ConfigWithException properties) {
        validateProperties(properties);
    }

    private void validateProperties(ConfigWithException properties) {
       if(properties.age() == null){
           throw new ConfigurationException("------- age cannot be null  ------");
       }
    }
}