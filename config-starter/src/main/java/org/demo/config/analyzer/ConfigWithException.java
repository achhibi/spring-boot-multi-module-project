package org.demo.config.analyzer;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("conf")
public record ConfigWithException (String age){}