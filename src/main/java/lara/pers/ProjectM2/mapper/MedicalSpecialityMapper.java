package lara.pers.ProjectM2.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


import lara.pers.ProjectM2.dto.MedicalSpecialityDTO;

import lara.pers.ProjectM2.entity.MedicalSpeciality;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MedicalSpecialityMapper {
    MedicalSpecialityDTO toDTO(MedicalSpeciality data);
    MedicalSpeciality toEntity(MedicalSpecialityDTO data);
    
}
