package lara.pers.ProjectM2.mapper;

import lara.pers.ProjectM2.dto.DoctorCreateDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import lara.pers.ProjectM2.dto.DoctorDTO;
import lara.pers.ProjectM2.entity.Doctor;

import java.util.Optional;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DoctorMapper {
    
    DoctorDTO toDTO(Doctor data);

    Doctor toEntity(DoctorDTO data);
    
}
