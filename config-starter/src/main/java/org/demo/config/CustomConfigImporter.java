package org.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.demo.config.annotations.EnableMyConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

@Slf4j
public class CustomConfigImporter implements ImportSelector {

    private static final Map<String, String> OCTOPUS_WS_MAP =
            Map.ofEntries(
                    entry("1", "A")   ,
                    entry("2", "B"),
                    entry("3", "C")
            );
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {

        AnnotationAttributes attributes = AnnotationAttributes
                .fromMap(metadata.getAnnotationAttributes(EnableMyConfig.class.getName(), true));

        var webservices = attributes.getStringArray("value");

        String[] params = Stream.concat(
                        OCTOPUS_WS_MAP.entrySet().stream().filter(e -> Arrays.stream(webservices).anyMatch(e.getKey()::equals))
                                .map(Map.Entry::getValue),
                        Stream.of("Z")
                )
                .toArray(String[]::new);
        log.info(" ------------------ import config ------------------------ {}", Stream.of(params).collect(Collectors.joining(" , ")));
        log.info(metadata.toString());
        return new String[]{ "org.demo.config.MyConfig" /*, "org.demo.config.component.MyService"*/};
    }
}