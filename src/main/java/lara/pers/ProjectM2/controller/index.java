package lara.pers.ProjectM2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Home")
public class index {


    @Autowired
    public index(){

    }


    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String indexStart(){
        log.info("Se accede a pagina princiapal de la aplicacion");
        return "Bienvenido a la API MedicineInyourHands";


    }
}
