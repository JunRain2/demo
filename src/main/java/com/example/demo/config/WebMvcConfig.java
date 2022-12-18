package com.example.demo.config;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

//CORS 방침 설정.
@Configuration//스프링 빈으로 등록.
public class WebMvcConfig implements WebMvcConfigurer {
    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry){
        //모든 경로에 대해
        registry.addMapping("/**")
                //Origin 이 https:localhost:3000인 경우,
                .allowedOrigins("http://localhost:3000")
                //GET, POST, PUT, PATCH, DELETE, OPTIONS 메서드를 허용한다.
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                //또한 헤더와 인증에관한 정보도 허용한다
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(MAX_AGE_SECS);
    }

}
