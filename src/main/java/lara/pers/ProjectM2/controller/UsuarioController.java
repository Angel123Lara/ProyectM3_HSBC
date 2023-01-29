package lara.pers.ProjectM2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.Valid;
import lara.pers.ProjectM2.dto.UsuarioDTO;
import lara.pers.ProjectM2.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import java.util.*;


@Slf4j
@Service
public class UsuarioController {
    private ClienteService service;

    @Autowired
    public UsuarioController(ClienteService service){
        this.service = service;
        log.info("Iniciando Cliente Controller");
    }

    @GetMapping
    public String start(){
        log.info("Acceso a pagina principal del Cliente Directory");
        return "This is the Cliente directory";
    }

    @GetMapping("/all")
    public List<UsuarioDTO> findAll(){
        log.info("Buscando todos los registros de la tabla Cliente");
        return service.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> creaDoctor (@Valid @RequestBody UsuarioDTO data){
        
        log.info("Guardando registro nuevo en tabla Cliente");
        
        return ResponseEntity.status(201).body(service.save(data));
        
    }   

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody UsuarioDTO data) throws Exception {
        log.info("Actualizando registro" + id + "en Table Cliente");
        service.update(id, data);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        log.info("Borrando registro " + id + "en Tabla Cliente");
        service.delete(id);
    }
    
}
