package com.fbdls.port1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    public WebConfig() {
        System.out.println("🛡️ WebConfig 생성됨! CORS 설정 시작!");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                System.out.println("🔓 CORS 매핑됨!");
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:3000",
                                "https://portfolio-start-ten.vercel.app",
                                "https://portfolio-start-git-main-ryus-projects-a49bff1b.vercel.app",
                                "https://ryudoll-dev.com",
                                "https://www.ryudoll-dev.com",
                                "https://www.ryudolldev.com"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true)  // ✅ 이거 필수
                        .exposedHeaders("Set-Cookie");  // ✅ 인증 쿠키 주고받기 위함
            }
        };
    }
}


