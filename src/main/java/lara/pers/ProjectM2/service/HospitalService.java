package lara.pers.ProjectM2.service;

import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.dto.HospitalDTO;

public interface HospitalService {
    List<HospitalDTO> findAll();

    Optional<HospitalDTO> findById(long id);

    HospitalDTO save(HospitalDTO data);

    void update(long id, HospitalDTO data) throws Exception;

    void delete(long id) throws Exception;
}
