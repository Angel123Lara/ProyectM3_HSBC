package lara.pers.ProjectM2.service.impls;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lara.pers.ProjectM2.dto.DoctorsDTO;
import lara.pers.ProjectM2.entity.Doctors;
import lara.pers.ProjectM2.mapper.DoctorsMapper;
import lara.pers.ProjectM2.repository.DoctorsRepository;
import lara.pers.ProjectM2.service.DoctorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DoctorsServiceImpl implements DoctorService {

    private DoctorsMapper mapper;
    private DoctorsRepository repository;

    @Autowired
    public DoctorsServiceImpl(DoctorsMapper mapper, DoctorsRepository repository){
        this.mapper = mapper;
        this.repository = repository;
        
        log.info("Constructor DoctorsServiceImpl listo");
    }

    public List<DoctorsDTO> findAll() {
        List<Doctors> hospitals  = repository.findAll();
        
        log.info("metodo findAll() realizado con exito en DoctorsServiceImpl");
        return hospitals.stream().map(mapper::toDTO).toList(); 
    }

    public Optional<DoctorsDTO> findById(long id){

        return null;
    }

    public DoctorsDTO save(DoctorsDTO data){
        Doctors entity = mapper.toEntity(data);
        log.info("metodo save() realizado con exito en DoctorsServiceImpl");
        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, DoctorsDTO  data) throws Exception {
        Optional<Doctors> result = repository.findById(id);
    
        if (result.isEmpty()) {
          log.warn("Result vacio en findById en DoctorsServiceImpl");
          throw new Exception("We can't found the Doctor");
        }
    
        Doctors hospital = result.get();
        
        hospital.setName(data.getName());
        log.info("metodo update() realizado con exito en DoctorsServiceImpl");
        repository.save(hospital);
      }
    
      public void delete(long id) throws Exception {
        Optional<Doctors> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Doctor doesn't exist");
        }
        log.info("metodo delete() realizado con exito en DoctorsServiceImpl");
        repository.deleteById(id);
      }    
    
}
