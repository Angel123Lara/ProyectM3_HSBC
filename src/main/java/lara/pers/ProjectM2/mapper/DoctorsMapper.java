package lara.pers.ProjectM2.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import lara.pers.ProjectM2.dto.DoctorsDTO;
import lara.pers.ProjectM2.entity.Doctors;



@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DoctorsMapper {
    
    DoctorsDTO toDTO(Doctors data);
    Doctors toEntity(DoctorsDTO data);
}
