package com.example.exceptionhandlingdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof ResourceNotFound) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            modelAndView.setViewName("error-404");
            modelAndView.addObject("error", "Resource not found");
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            modelAndView.setViewName("error-500");
            modelAndView.addObject("error", ex.getMessage());
        }
        return modelAndView;
    }
}
