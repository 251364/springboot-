package io.rong.exception.error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author ming 定义全局异常处理
 * @RestControllerAdvice 是@controlleradvice 与@ResponseBody 的组合注解
 */
@RestControllerAdvice 
public class GlobalControllerExceptionHandler {
   //约束违反例外,例如设置必填访问参数，却没有填加这个参数
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse ConstraintViolationException(ConstraintViolationException ex) {
        return new ApiErrorResponse(500, 5001, ex.getMessage());
    }
    
    //非法参数异常
    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse IllegalArgumentException(IllegalArgumentException ex) {
        return new ApiErrorResponse(400, 5002, "数据不匹配，请检查参数");
    }
//没有发现处理程序异常
    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse NoHandlerFoundException(Exception ex) {
        return new ApiErrorResponse(404, 4041, ex.getMessage());
    }

    //未知异常
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse unknownException(Exception ex) {
        return new ApiErrorResponse(500, 5002, ex.getMessage());
        
    }
    
 
    
}
