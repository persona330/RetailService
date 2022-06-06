package com.example.retail.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties
{
    private String uploadPath;

    public String getUploadPath() { return uploadPath; }
    public void setUploadPath(String uploadPath) { this.uploadPath = uploadPath; }
}
