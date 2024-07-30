package com.ptvinh203.interceptor.config;

import com.ptvinh203.interceptor.interceptor.RequestProcessingTimeInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class RequestInterceptorConfig implements WebMvcConfigurer {

    private final RequestProcessingTimeInterceptor requestProcessingTimeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestProcessingTimeInterceptor);
    }
}
