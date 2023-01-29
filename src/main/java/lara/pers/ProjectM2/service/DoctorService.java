package lara.pers.ProjectM2.service;

import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.dto.DoctorsDTO;


public interface DoctorService {
    List<DoctorsDTO> findAll();

    Optional<DoctorsDTO> findById(long id);

    DoctorsDTO save(DoctorsDTO data);

    void update(long id, DoctorsDTO data) throws Exception;

    void delete(long id) throws Exception;
}
