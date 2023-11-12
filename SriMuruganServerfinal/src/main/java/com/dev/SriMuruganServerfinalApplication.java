package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SriMuruganServerfinalApplication {
	
 
	public static void main(String[] args) {
		SpringApplication.run(SriMuruganServerfinalApplication.class, args);
	}
	
	@Bean
    public  WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Adjust the mapping to match your API endpoints
                    .allowedOrigins("http://localhost:3000") // Replace with the actual origin of your React app
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // Add the HTTP methods you need
                    .allowedHeaders("*"); // You can specify allowed headers or use "*" to allow all
            }
        };
    }

}
