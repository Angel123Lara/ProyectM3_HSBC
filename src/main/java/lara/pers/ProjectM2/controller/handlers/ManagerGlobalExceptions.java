package lara.pers.ProjectM2.controller.handlers;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lara.pers.ProjectM2.entity.ResponseError;

@RestControllerAdvice
public class ManagerGlobalExceptions extends ResponseEntityExceptionHandler{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleStatusException (MethodArgumentNotValidException ex,
                                                    WebRequest request){
        return ResponseError.builder()
                .exceptions(ex)
                .ruta(request.getDescription(false).substring(4))
                .entity();
                                                    }


   

}
