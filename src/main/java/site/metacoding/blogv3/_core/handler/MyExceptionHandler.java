package site.metacoding.blogv3._core.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import site.metacoding.blogv3._core.exception.*;
import site.metacoding.blogv3._core.util.Script;


@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception400.class)
    public String ex400(Exception400 e){
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(Exception401.class)
    public String ex401(Exception401 e){
        return Script.back(e.getMessage());
    }
    @ExceptionHandler(Exception403.class)
    public String ex403(RuntimeException e){
        return Script.back(e.getMessage());
    }
    @ExceptionHandler(Exception404.class)
    public String ex404(RuntimeException e){
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(Exception500.class)
    public String ex500(RuntimeException e){
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public String exUnknown(Exception e){
        return Script.back(e.getMessage());
    }

}
