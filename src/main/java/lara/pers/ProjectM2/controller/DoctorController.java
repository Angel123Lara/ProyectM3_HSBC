package lara.pers.ProjectM2.controller;


import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.controller.handlers.CustomException;
import lara.pers.ProjectM2.controller.handlers.DbException;
import lara.pers.ProjectM2.dto.DoctorCreateDTO;
import lara.pers.ProjectM2.dto.DoctorPatchDTO;
import lara.pers.ProjectM2.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lara.pers.ProjectM2.dto.DoctorDTO;

import lara.pers.ProjectM2.service.DoctorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/doctor")
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
        return "Directorio de Doctores";
    }

    @GetMapping("/{name}")
    public DoctorDTO findByName(@PathVariable("name") String name) throws Exception{
        try {
            log.info("buscando doctor por nombre :"+ name);
            DoctorDTO result = service.findByName(name);
            return result;
        }catch (Exception ex){
            throw new DbException("DB error", ex.getMessage());
    }
    }
    @GetMapping("/all")
    public List<DoctorDTO> findAll() throws Exception{
        try {
            log.info("Buscando todos los registros de la tabla Doctor");
            return service.findAll();
        }catch (Exception ex){
            throw new DbException("DB error", ex.getMessage());
        }
        }

   
    @PostMapping("/create")
    public ResponseEntity<DoctorDTO> creaDoctor (@Valid @RequestBody DoctorCreateDTO doctor) throws Exception {
        try {
            log.info("Guardando registro nuevo en tabla Doctor");
            DoctorDTO result = service.save(doctor);
            log.info("Resultado de save" + result);
            return ResponseEntity.status(201).body(result);
        }catch (Exception ex){
            throw new DbException("DB Error", ex.getMessage());
        }
        }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @Valid @RequestBody DoctorCreateDTO data) throws Exception {
        try {
            log.info("Actualizando registro" + id + "en Tabla Doctor");
            service.update(id, data);
        } catch (DbException ex) {
            throw new DbException("DB error", ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatch(@PathVariable("id") long id, @RequestBody DoctorPatchDTO data) throws Exception {
        try {
            log.info("Actualizando registro" + id + "en Tabla Doctor");
            service.updatePatch(id, data);
        } catch (DbException ex) {
            throw new DbException("DB error", ex.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) throws Exception{
        try {
            log.info("Borrando registro " + id + "en Tabla Doctor");
            service.delete(id);

        }catch (Exception ex){
         throw new DbException("DB Error", ex.getMessage());
        }

}
}
