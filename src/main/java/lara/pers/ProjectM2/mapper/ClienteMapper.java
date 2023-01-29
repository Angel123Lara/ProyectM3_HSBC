package lara.pers.ProjectM2.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import lara.pers.ProjectM2.dto.ClienteDTO;
import lara.pers.ProjectM2.entity.Cliente;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente data);
    Cliente toEntity(ClienteDTO data);
    
}
