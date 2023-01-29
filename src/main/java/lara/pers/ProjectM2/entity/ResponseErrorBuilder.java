package lara.pers.ProjectM2.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;


public class ResponseErrorBuilder {
    private int status;
    private Map<String,String> errors;
    private String ruta;

    public ResponseErrorBuilder status (int status){
        this.status = status;
        return this;
    }
    
    public ResponseErrorBuilder status (HttpStatus status){
        this.status = status.value();

        return this;
    }

    public ResponseErrorBuilder errores(Map<String,String> error){
        this.errors = error;
        return this;
    }   
    
   
    public ResponseErrorBuilder exceptions(MethodArgumentNotValidException ex){
        HttpStatus status = HttpStatus.BAD_REQUEST; 
        this.status = status.value();
        this.errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return this;

    }



    public ResponseErrorBuilder ruta(String ruta){
        this.ruta = ruta;
        return this;
    }

    public ResponseError build(){
        ResponseError response = new ResponseError();

        response.setStatus(this.status);
        response.setErrores(this.errors);
        response.setRuta(this.ruta);

        return response;
    }

    public ResponseEntity<ResponseError> entity(){
        return ResponseEntity.status(status)
                             .headers(HttpHeaders.EMPTY)
                             .body(build());
    }
}
