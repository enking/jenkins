package com.ohgiraffers.jenkins.bootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class webConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // nodeport 설정으로 처리할때는 origin이 달라서 cors 처리가 필요함
                //.allowedOrigins("http://localhost:30000")
                // ingress 설정 시 단일 진입점ㅇ르 사용하므로 cors 처리가 불필요함
                // 다만 다른 cors처리가 필요할 가능성을 염두에 두고 코드만 남겨 두었음
                .allowedOrigins()
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS");
    }
}
