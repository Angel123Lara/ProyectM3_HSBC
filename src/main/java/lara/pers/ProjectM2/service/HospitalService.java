package lara.pers.ProjectM2.service;

import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.dto.*;
import lara.pers.ProjectM2.entity.Doctor;
import lara.pers.ProjectM2.entity.Hospital;

public interface HospitalService {
    List<HospitalDTO> findAll();

    HospitalDTO save(HospitalCreateDTO data) throws Exception;

    HospitalDTO findByName(String name) throws Exception;
    void update(long id, HospitalCreateDTO data) throws Exception;

    void delete(long id) throws Exception;
}
