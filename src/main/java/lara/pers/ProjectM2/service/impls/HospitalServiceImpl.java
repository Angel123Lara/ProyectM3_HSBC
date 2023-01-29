package lara.pers.ProjectM2.service.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lara.pers.ProjectM2.dto.HospitalDTO;
import lara.pers.ProjectM2.entity.Hospital;
import lara.pers.ProjectM2.mapper.HospitalMapper;
import lara.pers.ProjectM2.repository.HospitalRepository;
import lara.pers.ProjectM2.service.HospitalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HospitalServiceImpl implements HospitalService {

    private HospitalMapper mapper;
    private HospitalRepository repository;

    @Autowired
    public HospitalServiceImpl(HospitalMapper mapper, HospitalRepository repository){
        this.mapper = mapper;
        this.repository = repository;
        log.info("Constructor HospitalServiceImpl listo");
    }

    public List<HospitalDTO> findAll(){
        List<Hospital> hospitals  = repository.findAll();
        log.info("metodo findAll() realizado con exito en HospitalServiceImpl");
        return hospitals.stream().map(mapper::toDTO).toList(); 
    }

    public Optional<HospitalDTO> findById(long id){
        return null;
    }

    public HospitalDTO save(HospitalDTO data){
        Hospital entity = mapper.toEntity(data);
        log.info("metodo save() realizado con exito en HospitalServiceImpl");
        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, HospitalDTO data) throws Exception {
        Optional<Hospital> result = repository.findById(id);
    
        if (result.isEmpty()) {
          log.warn("Result vacio en findById en HospitalServiceImpl");
          throw new Exception("We can't found the hospital");
        }
    
        Hospital hospital = result.get();
    
        hospital.setName(data.getName());
        log.info("metodo update() realizado con exito en HospitalServiceImpl");
        repository.save(hospital);
      }
    
      public void delete(long id) throws Exception {
        Optional<Hospital> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Hospital doesn't exist");
        }
        log.info("metodo delete() realizado con exito en HospitalServiceImpl");
        repository.deleteById(id);
      }    
    
}
