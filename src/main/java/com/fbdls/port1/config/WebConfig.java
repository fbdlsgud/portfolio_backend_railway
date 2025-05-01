package com.fbdls.port1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:3000",
                                "https://portfolio-start-ten.vercel.app",
                                "https://portfolio-start-git-main-ryus-projects-a49bff1b.vercel.app",
                                "https://ryudoll-dev.com",                        // ✅ 이거 추가!!
                                "https://www.ryudoll-dev.com"                     // ✅ 이거도 있으면 좋아요
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}

