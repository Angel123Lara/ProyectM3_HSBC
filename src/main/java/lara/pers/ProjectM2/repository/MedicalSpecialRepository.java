package lara.pers.ProjectM2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lara.pers.ProjectM2.entity.MedicalSpeciality;

@Repository
public interface MedicalSpecialRepository extends JpaRepository<MedicalSpeciality, Long>{
    
}
