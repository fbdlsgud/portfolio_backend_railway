package com.fbdls.port1.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 요청 경로에 대해
                .allowedOrigins("http://localhost:3000") // 허용할 프론트 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 방식
                .allowedHeaders("*") // 어떤 헤더든 허용
                .allowCredentials(true); // 쿠키 등 인증 포함 허용
    }
}
