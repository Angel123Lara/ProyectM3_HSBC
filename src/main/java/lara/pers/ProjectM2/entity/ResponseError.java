package lara.pers.ProjectM2.entity;

import java.time.LocalDateTime;
import java.util.Map;


import lombok.Getter;
import lombok.Setter;

public class ResponseError {

    @Getter
    private final LocalDateTime timestamp = LocalDateTime.now();

    public static ResponseErrorBuilder builder(){
        return new ResponseErrorBuilder();
    }
    @Getter
    @Setter
    private int status;
    @Getter
    @Setter
    private Map<String,String> errores;
    @Getter
    @Setter
    private String ruta;

    
}
