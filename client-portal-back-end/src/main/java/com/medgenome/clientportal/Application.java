package com.medgenome.clientportal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {
    @Value("${genome.asia.allowed.origins:*}")
    private String[] allowedOrigins;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    //    @Bean
//    public FilterRegistrationBean tokenAuthenticationFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new CORSFilter());
//        registration.addUrlPatterns("/user/*");
//        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
//        return registration;
//    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(allowedOrigins);
            }
        };
    }
}

