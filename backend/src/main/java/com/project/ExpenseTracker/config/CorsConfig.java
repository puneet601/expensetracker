package com.project.ExpenseTracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	 registry.addMapping("/**") // Allow CORS for all URLs
         .allowedOrigins("*") // Specify the allowed origin (your React app's URL)
         .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify the allowed HTTP methods
         .allowedHeaders("*"); // Allow all headers (you can specify specific headers if needed)
  }
}
