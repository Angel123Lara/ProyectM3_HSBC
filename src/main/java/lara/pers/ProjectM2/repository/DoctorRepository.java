package lara.pers.ProjectM2.repository;

import lara.pers.ProjectM2.dto.DoctorDTO;
import lara.pers.ProjectM2.dto.DoctorSimpleGetDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.hateoas.mediatype.alps.Doc;
import org.springframework.stereotype.Repository;
import java.util.*;
import lara.pers.ProjectM2.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByNameAndCedula(String name, String cedula);

    Optional<Doctor> findByCedula(String cedula);

    Doctor findByName(String name);
    
}
