package lara.pers.ProjectM2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lara.pers.ProjectM2.entity.MedicalSpeciality;

import java.util.Optional;

@Repository
public interface MedicalSpecialRepository extends JpaRepository<MedicalSpeciality, Long>{
    Optional<MedicalSpeciality> findByName(String name);
}
