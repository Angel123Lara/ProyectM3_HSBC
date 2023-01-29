package lara.pers.ProjectM2.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import lara.pers.ProjectM2.dto.UsuarioDTO;
import lara.pers.ProjectM2.entity.Usuario;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario data);
    Usuario toEntity(UsuarioDTO data);
    
}
