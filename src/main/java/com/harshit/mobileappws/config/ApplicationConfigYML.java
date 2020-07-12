package com.harshit.mobileappws.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

// marking the class as a source of Bean definition.
@Configuration
// enable the class with @Configuration to be a bean source in spring boot application
@EnableConfigurationProperties
// binds and validate the external configuration to the class
@ConfigurationProperties
public class ApplicationConfigYML {
    private String name;
    private String environment;
    private List<String> servers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }
}
