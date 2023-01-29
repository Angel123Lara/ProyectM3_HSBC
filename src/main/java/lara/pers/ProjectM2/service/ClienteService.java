package lara.pers.ProjectM2.service;

import java.util.List;
import java.util.Optional;

import lara.pers.ProjectM2.dto.ClienteDTO;

public interface ClienteService {
    List<ClienteDTO> findAll();

    Optional<ClienteDTO> findById(long id);

    ClienteDTO save(ClienteDTO data);

    void update(long id, ClienteDTO data) throws Exception;

    void delete(long id) throws Exception;    
}
