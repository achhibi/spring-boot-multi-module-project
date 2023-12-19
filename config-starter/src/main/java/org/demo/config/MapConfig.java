package org.demo.config;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Collectors;


@Configuration
@Slf4j
@EnableConfigurationProperties({ MapConfiguer.class })
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MapConfig {

    MapConfiguer configuer;

    @Bean
    public Map<String, String> map() {
        log.info("********** creation map Bean *********: {}",  configuer.getMap().entrySet().stream().map(e-> String.format("[ %s, %s]", e.getKey(), e.getValue())).collect(Collectors.joining(" , ")));
        return configuer.getMap();
    }
}
