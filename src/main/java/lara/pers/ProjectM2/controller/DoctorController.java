package lara.pers.ProjectM2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lara.pers.ProjectM2.dto.DoctorsDTO;
import lara.pers.ProjectM2.service.DoctorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private DoctorService service;

    @Autowired
    public DoctorController(DoctorService service){
        this.service = service;
        log.info("Iniciando Doctor Controller");
    }

    @GetMapping
    public String start(){
        log.info("Acceso a pagina principal del Doctor Directory");
        return "This is the Doctor directory";
    }

    @GetMapping("/all")
    public List<DoctorsDTO> findAll(){
        log.info("Buscando todos los registros de la tabla Doctor");
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorsDTO save(@RequestBody DoctorsDTO data){
        log.info("Guardando registro nuevo en tabla Doctor");
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody DoctorsDTO data) throws Exception {
        log.info("Actualizando registro" + id + "en Tabla Doctor");
        service.update(id, data);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        log.info("Borrando registro " + id + "en Tabla Doctor");
        service.delete(id);
    }
}
