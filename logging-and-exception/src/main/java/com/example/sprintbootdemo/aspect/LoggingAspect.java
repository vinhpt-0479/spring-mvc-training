package com.example.sprintbootdemo.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.sprintbootdemo.controller.rest..*(..)) || execution(* com.example.sprintbootdemo.controller.view..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // Get request details
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String requestMethod = request.getMethod();
            String requestURI = request.getRequestURI();
            String clientIP = request.getRemoteAddr();
            String protocol = request.getProtocol();
            logger.info("{}:{} - {} {} {}", clientIP, request.getRemotePort(), protocol, requestMethod, requestURI);
        } else {
            logger.warn("Could not get request attributes for logging");
        }
    }
}