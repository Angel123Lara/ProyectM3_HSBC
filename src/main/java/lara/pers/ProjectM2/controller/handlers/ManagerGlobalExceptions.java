package lara.pers.ProjectM2.controller.handlers;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lara.pers.ProjectM2.entity.ResponseError;

@RestControllerAdvice
public class ManagerGlobalExceptions {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleStatusException (MethodArgumentNotValidException ex,
                                                    WebRequest request) {
        return ResponseError.builder()
                .exceptions(ex)
                .ruta(request.getDescription(false).substring(4))
                .entity();
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException exDup,
                                                   WebRequest request) {
        return ResponseError.builder()
                .exceptions(exDup)
                .ruta(request.getDescription(false).substring(4))
                .entity();

    }

    @ExceptionHandler(DbException.class)
    public ResponseEntity<?> handleCustomException(DbException exDB,
                                                   WebRequest request) {
        return ResponseError.builder()
                .exceptions(exDB)
                .ruta(request.getDescription(false).substring(4))
                .entity();

    }
}


   


