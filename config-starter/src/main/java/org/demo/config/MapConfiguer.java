package org.demo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "conf")
@Data
@Validated
public class MapConfiguer {

    @NotEmpty(message = "Il faut avoir au moins une propriété map.")
    private Map<String, String> map = new HashMap<>();;
}
