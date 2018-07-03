package com.swoop.sampleapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationServiceProperties {

    @Value("${debug}")
    private boolean debug;

    public boolean isDebug() {
        return debug;
    }
}
