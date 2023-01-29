package lara.pers.ProjectM2.service.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lara.pers.ProjectM2.dto.MedicalSpecialityDTO;
import lara.pers.ProjectM2.entity.MedicalSpeciality;
import lara.pers.ProjectM2.mapper.MedicalSpecialityMapper;

import lara.pers.ProjectM2.repository.MedicalSpecialRepository;
import lara.pers.ProjectM2.service.MedicalSpecialityService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicalSpecialityImpl implements MedicalSpecialityService {

    private MedicalSpecialityMapper mapper;
    private MedicalSpecialRepository repository;

    @Autowired
    public MedicalSpecialityImpl (MedicalSpecialityMapper mapper, MedicalSpecialRepository repository){
        this.mapper = mapper;
        this.repository = repository;
        log.info("Constructor MedicalSpecialityImpl listo");
    }

    public List<MedicalSpecialityDTO> findAll(){
        List<MedicalSpeciality> medicalSpeciality  = repository.findAll();
        log.info("metodo findAll() realizado con exito en MedicalSpecialityImp");
        return medicalSpeciality.stream().map(mapper::toDTO).toList(); 
    }

    public Optional<MedicalSpecialityDTO> findById(long id){
        return null;
    }

    public MedicalSpecialityDTO save(MedicalSpecialityDTO data){
        MedicalSpeciality entity = mapper.toEntity(data);
        log.info("metodo save() realizado con exito en MedicalSpecialityImpl");
        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, MedicalSpecialityDTO data) throws Exception {
        Optional<MedicalSpeciality> result = repository.findById(id);
    
        if (result.isEmpty()) {
          log.warn("Result vacio en findById en MedicalSpecialityImpl");
          throw new Exception("We can't found the MedicalSpecility");
        }
    
        MedicalSpeciality hospital = result.get();
    
        hospital.setName(data.getName());
        log.info("metodo update() realizado con exito en MedicalSpecialityImpl");
        repository.save(hospital);
      }
    
      public void delete(long id) throws Exception {
        Optional<MedicalSpeciality> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Medical Speciality doesn't exist");
        }
        log.info("metodo delete() realizado con exito en Medical Speciality");
        repository.deleteById(id);
      }    
    
}
