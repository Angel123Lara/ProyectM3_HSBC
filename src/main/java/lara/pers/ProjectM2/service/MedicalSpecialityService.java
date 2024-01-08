package lara.pers.ProjectM2.service;

import java.util.List;
import java.util.Optional;


import lara.pers.ProjectM2.dto.MedSpecialCreateDTO;
import lara.pers.ProjectM2.dto.MedicalSpecialityDTO;
import lara.pers.ProjectM2.entity.MedicalSpeciality;

public interface MedicalSpecialityService{
    List<MedicalSpecialityDTO> findAll();

    Optional<MedicalSpecialityDTO> findById(long id);

    MedicalSpecialityDTO findByName(String name);

    MedicalSpecialityDTO save(MedSpecialCreateDTO data);

    void update(long id, MedicalSpecialityDTO data) throws Exception;

    void delete(long id) throws Exception;
}
