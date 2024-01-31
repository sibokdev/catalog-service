package com.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//class to define custom properties in a spring bean
@ConfigurationProperties(prefix = "polar") // marks the class as config with the prefix polar
public class PolarProperties {
    /**
     * A message to welcome users.
     */
    private String greeting; // propertie can be accesed with prefix + name example polar.greeting
    public String getGreeting() {
        return greeting;
    }
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}