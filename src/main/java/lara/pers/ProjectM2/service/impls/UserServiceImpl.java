package lara.pers.ProjectM2.service.impls;

import lara.pers.ProjectM2.dto.UsuarioDTO;
import lara.pers.ProjectM2.entity.Usuario;
import lara.pers.ProjectM2.mapper.UsuarioMapper;
import lara.pers.ProjectM2.repository.ClienteRepository;
import lara.pers.ProjectM2.service.ClienteService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserServiceImpl implements ClienteService {
    
    private UsuarioMapper mapper;
    private ClienteRepository repository;

    @Autowired
    public UserServiceImpl(UsuarioMapper mapper, ClienteRepository repository){
        this.mapper = mapper;
        this.repository = repository;
        
        log.info("Constructor ClienteServiceImpl listo");
    }

    public List<UsuarioDTO> findAll() {
        List<Usuario> hospitals  = repository.findAll();
        
        log.info("metodo findAll() realizado con exito en ClienteServiceImpl");
        return hospitals.stream().map(mapper::toDTO).toList(); 
    }

    public Optional<UsuarioDTO> findById(long id){

        return null;
    }

 
    public UsuarioDTO save(UsuarioDTO data){
        Usuario entity = mapper.toEntity(data);
        log.info("metodo save() realizado con exito en ClienteServiceImpl");
        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, UsuarioDTO  data) throws Exception {
        Optional<Usuario> result = repository.findById(id);
    
        if (result.isEmpty()) {
          log.warn("Result vacio en findById en ClienteServiceImpl");
          throw new Exception("We can't found the Doctor");
        }
    
        Usuario cliente = result.get();
        
        cliente.setName(data.getName());
        log.info("metodo update() realizado con exito en ClienteServiceImpl");
        repository.save(cliente);
      }
    
      public void delete(long id) throws Exception {
        Optional<Usuario> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Cliente doesn't exist");
        }
        log.info("metodo delete() realizado con exito en DoctorsServiceImpl");
        repository.deleteById(id);
      }

      @Override
      public Optional<UsuarioDTO> findOneByEmail(String email) {
        // TODO Auto-generated method stub
        return Optional.empty();
      }    
    
}
