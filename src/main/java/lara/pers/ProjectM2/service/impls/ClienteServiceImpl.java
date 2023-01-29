package lara.pers.ProjectM2.service.impls;

import lara.pers.ProjectM2.dto.ClienteDTO;
import lara.pers.ProjectM2.entity.Cliente;
import lara.pers.ProjectM2.mapper.ClienteMapper;
import lara.pers.ProjectM2.repository.ClienteRepository;
import lara.pers.ProjectM2.service.ClienteService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClienteServiceImpl implements ClienteService {
    
    private ClienteMapper mapper;
    private ClienteRepository repository;

    @Autowired
    public ClienteServiceImpl(ClienteMapper mapper, ClienteRepository repository){
        this.mapper = mapper;
        this.repository = repository;
        
        log.info("Constructor ClienteServiceImpl listo");
    }

    public List<ClienteDTO> findAll() {
        List<Cliente> hospitals  = repository.findAll();
        
        log.info("metodo findAll() realizado con exito en ClienteServiceImpl");
        return hospitals.stream().map(mapper::toDTO).toList(); 
    }

    public Optional<ClienteDTO> findById(long id){

        return null;
    }

    public ClienteDTO save(ClienteDTO data){
        Cliente entity = mapper.toEntity(data);
        log.info("metodo save() realizado con exito en ClienteServiceImpl");
        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, ClienteDTO  data) throws Exception {
        Optional<Cliente> result = repository.findById(id);
    
        if (result.isEmpty()) {
          log.warn("Result vacio en findById en ClienteServiceImpl");
          throw new Exception("We can't found the Doctor");
        }
    
        Cliente cliente = result.get();
        
        cliente.setName(data.getName());
        log.info("metodo update() realizado con exito en ClienteServiceImpl");
        repository.save(cliente);
      }
    
      public void delete(long id) throws Exception {
        Optional<Cliente> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Cliente doesn't exist");
        }
        log.info("metodo delete() realizado con exito en DoctorsServiceImpl");
        repository.deleteById(id);
      }    
    
}
