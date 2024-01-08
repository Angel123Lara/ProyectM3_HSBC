package lara.pers.ProjectM2.controller;

import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.dto.MedSpecialCreateDTO;
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
import lara.pers.ProjectM2.dto.MedicalSpecialityDTO;
import lara.pers.ProjectM2.service.MedicalSpecialityService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/MedicalSpeciality")
public class MedicalSpecialityController {

    private MedicalSpecialityService service;

    @Autowired
    public MedicalSpecialityController(MedicalSpecialityService service){
        log.info("Iniciando Medical Speciality Controller");
        this.service = service;
    }

    @GetMapping
    public String start(){
        log.info("Acceso a pagina principal del Medical Speciality Directory");
        return "Directorio de Especialidades";
    }

    @GetMapping("/all")
    public List<MedicalSpecialityDTO> findAll(){
        log.info("Buscando todos los registros de la tabla Speciality");
        return service.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<MedicalSpecialityDTO> creaDoctor (@Valid @RequestBody MedSpecialCreateDTO data){
        
        log.info("Guardando registro nuevo en tabla Doctor");
        
        return ResponseEntity.status(201).body(service.save(data));
        
    }
    @GetMapping("/{name}")
    public MedicalSpecialityDTO findName(@PathVariable("name") String name){
        log.info("Buscando el registro MedSpecial:" + name);
        return service.findByName(name);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody MedicalSpecialityDTO data) throws Exception {
        log.info("Actualizando registro" + id + "en Tabla Medical Speciality");
        service.update(id, data);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        log.info("Borrando registro " + id + "en Tabla Medical Speciality");
        service.delete(id);
    }
}
