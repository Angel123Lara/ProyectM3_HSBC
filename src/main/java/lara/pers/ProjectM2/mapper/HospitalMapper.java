package lara.pers.ProjectM2.mapper;

import lara.pers.ProjectM2.dto.HospitalCreateDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import lara.pers.ProjectM2.dto.HospitalDTO;
import lara.pers.ProjectM2.entity.Hospital;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface HospitalMapper {
    HospitalDTO toDTO(Hospital data);
    Hospital toEntity(HospitalDTO data);

    Hospital toEntityToBD(HospitalCreateDTO data);

    HospitalDTO toDTOFromBD(Hospital data);


}
