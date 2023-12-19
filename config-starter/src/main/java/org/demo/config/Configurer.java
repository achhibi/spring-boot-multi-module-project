package org.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("config")
@Validated
public record Configurer(@NotBlank(message = "{message.required.config.name}") String name,
						 @NotBlank(message = "{message.required.config.version}") String version) {
}