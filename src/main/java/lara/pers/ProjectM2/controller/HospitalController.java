package lara.pers.ProjectM2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lara.pers.ProjectM2.dto.HospitalDTO;
import lara.pers.ProjectM2.service.HospitalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    private HospitalService service;

    @Autowired
    public HospitalController(HospitalService service){
        this.service = service;
        log.info("Iniciando Hospital Controller");
    }

    @GetMapping
    public String start(){
        log.info("Acceso a pagina principal del Hospital Directory");
        return "Directorio de Hospitales";
    }

    @GetMapping("/all")
    public List<HospitalDTO> findAll(){
        log.info("Buscando todos los registros de la tabla Hospital");
        return service.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<HospitalDTO> creaDoctor (@Valid @RequestBody HospitalDTO data){
        
        log.info("Guardando registro nuevo en tabla Doctor");
        
        return ResponseEntity.status(201).body(service.save(data));
        
    } 

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody HospitalDTO data) throws Exception {
        log.info("Actualizando registro" + id + "en Tabla Hospital");
        service.update(id, data);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        log.info("Borrando registro " + id + "en Tabla Hospital");
        service.delete(id);
    }
}
