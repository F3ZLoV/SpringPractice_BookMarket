package com.springboot.bookmarket.config;

import com.springboot.bookmarket.interceptor.AuditingInterceptor;
import com.springboot.bookmarket.interceptor.MonitoringInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoggingConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MonitoringInterceptor());
        registry.addInterceptor(new AuditingInterceptor());
    }
}
