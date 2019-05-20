package com.yd.web.config;

import com.yd.web.interceptor.TokenInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig extends WebMvcAutoConfiguration {

    @Bean
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/getUser/*","/loginIn");
            }
        };
    }

}
