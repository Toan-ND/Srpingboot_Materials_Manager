package com.codegym.quanlivatlieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:upload.properties")
class AdditionalResourceWebConfiguration implements WebMvcConfigurer {
    @Autowired
    Environment ev;
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        String uploadPath = ev.getProperty("file_upload");
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+uploadPath);
    }
}
