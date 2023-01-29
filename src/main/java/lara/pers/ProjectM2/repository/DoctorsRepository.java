package lara.pers.ProjectM2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lara.pers.ProjectM2.entity.Doctors;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
    
}
