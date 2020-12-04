package com.sy.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ErrorHandler
 * @Description TODO
 * @Author Administrator
 * @Date: 2020/12/2 17:25
 * @Version 1.0
 */
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value=Exception.class)
    public Map<Integer,String> handleError(Exception e){
        Map<Integer,String> map = new HashMap<>();
        map.put(500,"error");
        return map;
    }
}
