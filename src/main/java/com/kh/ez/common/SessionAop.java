package com.kh.ez.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
public class SessionAop {
    @Before("execution(* com.kh.ez.*.controller.*.*(..))")
    public void beforeAdvice() {
        ServletRequestAttributes attributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        if (attributes != null) {
            HttpSession session = attributes.getRequest().getSession();

            session.removeAttribute("msg");
        }
    }
}
