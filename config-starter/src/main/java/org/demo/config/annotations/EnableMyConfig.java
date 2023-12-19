package org.demo.config.annotations;

import org.demo.config.CustomConfigImporter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({CustomConfigImporter.class})
//@ComponentScan(basePackages = "org.demo.config.component")
public @interface EnableMyConfig {

    Class[] value();
}