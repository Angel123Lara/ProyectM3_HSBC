package lara.pers.ProjectM2.controller;

import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.controller.handlers.DbException;
import lara.pers.ProjectM2.entity.Hospital;
import lara.pers.ProjectM2.entity.MedicalSpeciality;
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
import lara.pers.ProjectM2.dto.*;
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

    @GetMapping("/{name}")
    public HospitalDTO findByName(@PathVariable("name") String name) throws Exception{
        try {
            log.info("Buscando registro por nombre :" + name);
            HospitalDTO result = service.findByName(name);
            return result;
        }catch (Exception ex){
            throw new DbException("DB Error", ex.getMessage());
        }

    }
    @PostMapping("/create")
    public ResponseEntity<HospitalDTO> creaDoctor (@Valid @RequestBody HospitalCreateDTO data) throws Exception{
        try {
            log.info("Guardando registro nuevo en tabla Doctor");

            return ResponseEntity.status(201).body(service.save(data));
        }catch (Exception ex){
            throw new DbException("DB error", ex.getMessage());
        }

        
    } 

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody HospitalCreateDTO data) throws Exception {
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
