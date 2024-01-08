package lara.pers.ProjectM2.mapper;

import lara.pers.ProjectM2.dto.MedSpecialCreateDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


import lara.pers.ProjectM2.dto.MedicalSpecialityDTO;

import lara.pers.ProjectM2.entity.MedicalSpeciality;

import java.util.Optional;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MedicalSpecialityMapper {
    MedicalSpecialityDTO toDTO(MedicalSpeciality data);
    MedicalSpeciality toEntity(MedSpecialCreateDTO data);

    MedicalSpeciality OpToDTO(Optional<MedicalSpeciality> data);


    
}
