package lara.pers.ProjectM2.service;

import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.dto.DoctorCreateDTO;
import lara.pers.ProjectM2.dto.*;
import lara.pers.ProjectM2.entity.Doctor;

import javax.print.Doc;


public interface DoctorService {
    List<DoctorDTO> findAll();

    DoctorDTO findByName(String name) throws Exception;

    DoctorDTO save(DoctorCreateDTO data) throws Exception;

    void update(long id, DoctorCreateDTO data) throws Exception;

    void updatePatch(long id, DoctorPatchDTO data) throws Exception;
    void delete(long id) throws Exception;
    //Optional<DoctorDTO> existByNameAndCedula(String name, String cedula);
}
