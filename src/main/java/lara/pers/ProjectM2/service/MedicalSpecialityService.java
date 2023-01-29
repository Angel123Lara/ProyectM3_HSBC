package lara.pers.ProjectM2.service;

import java.util.List;
import java.util.Optional;


import lara.pers.ProjectM2.dto.MedicalSpecialityDTO;

public interface MedicalSpecialityService{
    List<MedicalSpecialityDTO> findAll();

    Optional<MedicalSpecialityDTO> findById(long id);

    MedicalSpecialityDTO save(MedicalSpecialityDTO data);

    void update(long id, MedicalSpecialityDTO data) throws Exception;

    void delete(long id) throws Exception;
}
