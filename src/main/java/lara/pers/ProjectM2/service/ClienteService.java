package lara.pers.ProjectM2.service;

import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.dto.UsuarioDTO;

public interface ClienteService {
    List<UsuarioDTO> findAll();

    Optional<UsuarioDTO> findById(long id);

    UsuarioDTO save(UsuarioDTO data);

    void update(long id, UsuarioDTO data) throws Exception;

    void delete(long id) throws Exception; 
    
    Optional<UsuarioDTO> findOneByEmail(String email);
}
