package lara.pers.ProjectM2.service.impls;
import java.util.*;
import java.util.stream.Collectors;


import lara.pers.ProjectM2.controller.handlers.CustomException;
import lara.pers.ProjectM2.dto.DoctorCreateDTO;
import lara.pers.ProjectM2.dto.DoctorPatchDTO;
import lara.pers.ProjectM2.entity.Hospital;
import lara.pers.ProjectM2.entity.MedicalSpeciality;
import lara.pers.ProjectM2.repository.HospitalRepository;
import lara.pers.ProjectM2.repository.MedicalSpecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lara.pers.ProjectM2.dto.DoctorDTO;
import lara.pers.ProjectM2.entity.Doctor;
import lara.pers.ProjectM2.mapper.DoctorMapper;
import lara.pers.ProjectM2.repository.DoctorRepository;
import lara.pers.ProjectM2.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorMapper mapper;
    private DoctorRepository repository;

    private HospitalRepository hospitalRepository;

    private MedicalSpecialRepository MedSpRepository;

    @Autowired
    public DoctorServiceImpl(DoctorMapper mapper, DoctorRepository repository, HospitalRepository hospitalRepository, MedicalSpecialRepository MedSpRepository){
        this.mapper = mapper;
        this.repository = repository;
        this.hospitalRepository = hospitalRepository;
        this.MedSpRepository = MedSpRepository;

        
        log.info("Constructor doctorServiceImpl listo");
    }

    public List<DoctorDTO> findAll() {
        List<Doctor> doctors  = repository.findAll();
        log.info("metodo findAll() realizado con exito en doctorServiceImpl");
        return doctors.stream().map(mapper::toDTO).toList();
    }

    public DoctorDTO findByName(String name) throws Exception{
        Doctor result = repository.findByName(name);
        return mapper.toDTO(result);
  }


    public DoctorDTO save(DoctorCreateDTO data) throws Exception,CustomException {

        Optional<Doctor> result = repository.findByNameAndCedula(data.getName(), data.getCedula());
        log.warn("Verificacion de que el doctor no exista con la misma cedula");
        Doctor doctor = new Doctor();
        Hospital hospitalNew = new Hospital();
        if (result.isPresent() == false ) {
            Optional<Hospital> hospital = Optional.ofNullable(data.getHospitalName())
                    .map(hosp -> hospitalRepository.findByName(data.getHospitalName()))
                    .orElse(Optional.empty());
            log.warn("Verificacion de si el hospital existe");
            if (hospital.isEmpty()) {
                log.info("El hospital existe DB");
                hospitalNew.setName(data.getHospitalName());
                hospitalNew.setAddress("Sin direccion registrada");
                hospitalNew.setPhone("Sin telefono");
                hospitalNew = hospitalRepository.save(hospitalNew);
                Long id_hospital = hospitalNew.getId();
                String id_str_hospital = id_hospital.toString();
                data.setHospitalName(id_str_hospital);
                doctor.setHospital(hospitalNew);
                log.info("Se creó nuevo Hospital");

                hospital = hospitalRepository.findByName(data.getHospitalName());
                log.info("Se asigna el valor que se guardo a hospital para usarse mas adelante");

            } else {
                log.info("El hospital existe DB");
                hospitalNew = hospital.get();
                Long id_hospital = hospitalNew.getId();
                String id_str_hospital = id_hospital.toString();
                data.setHospitalName(id_str_hospital);
                doctor.setHospital(hospitalNew);
            }
            log.info("Se revisa si la especialidad ingresada existe");
            log.info("Especialidad recibida en data" + data.getMedSpecial());

            //MedicalSpeciality medSpecial = MedSpRepository.findByName(data.getNameMedSpecial());
            Optional<MedicalSpeciality> medSpecial = Optional.ofNullable(data.getMedSpecial())
                    .map(medSp -> MedSpRepository.findByName(data.getMedSpecial()))
                    .orElse(Optional.empty());
            log.warn("info recibida en medSpecial" + medSpecial.isEmpty());
            if (medSpecial.isEmpty()) {
                log.info("medSpecial no existe, se procede a crear");
                MedicalSpeciality medSpecialNew = new MedicalSpeciality();
                medSpecialNew.setName(data.getMedSpecial());
                medSpecialNew.setInfo("info pendiente");
                medSpecialNew.setSchedule("Sin información");
                log.info("Save() medSpRepository");
                medSpecialNew = MedSpRepository.save(medSpecialNew);
                Long id_MedSpecial = medSpecialNew.getId();
                String id_str_MedSpecial = id_MedSpecial.toString();
                data.setMedSpecial(id_str_MedSpecial);
                doctor.setMedicalSpeciality(medSpecialNew);
                log.info("Se crea nueva Especialidad");
                // se agrega especialidad a Hospital
                if (hospitalNew.getMedicalSpecialities() == null) {
                            hospitalNew.setMedicalSpecialities(new ArrayList<>());
                            log.info("Se inicializa Lista");
                        }
                hospitalNew.getMedicalSpecialities().add(medSpecialNew);
                hospitalNew = hospitalRepository.save(hospitalNew);
                log.info("Se agrego especialidad a Hospital");
                if (medSpecialNew.getHospital() == null) {
                            medSpecialNew.setHospital(new ArrayList<>());
                            log.info("Se inicializa Lista");
                        }
                medSpecialNew.getHospital().add(hospitalNew);
                log.info("Se agrega hospital a especialidad");
                medSpecialNew = MedSpRepository.save(medSpecialNew);
                log.info("Se guarda hospital");

                } else {
                    log.info("MedSpecial existe en DB");
                    Long id_medSpecial = medSpecial.get().getId();
                    String id_str_medSpecial = id_medSpecial.toString();
                    data.setMedSpecial(id_str_medSpecial);
                    doctor.setMedicalSpeciality(medSpecial.get());
                }
            doctor.setName(data.getName());
            doctor.setCedula(data.getCedula());
            log.info("info al save " + data);
            log.info("metodo save() realizado con exito en doctorServiceImpl");
            return mapper.toDTO(repository.save(doctor));
        }
        else{
            log.warn("Doctor y cedula repetidos");
            throw new CustomException("Duplicate Values","The Doctor and Cedula exist in DB ");
        }

    }

    public void update(long id, DoctorCreateDTO data) throws CustomException {
       Optional<Doctor> result = Optional.ofNullable(id)
                .map(doc -> repository.findById(doc))
                .orElse(Optional.empty());
        if (result.isEmpty()) {
          log.warn("Result vacio en findById en doctorServiceImpl");
          throw new CustomException("NoFound", "We can't found the Doctor: " + data.getName());
        }
        Doctor doctor = result.get();
        if(data.getCedula() != null){
        Optional<Doctor> resultCed = Optional.ofNullable(data.getCedula())
                .map(ced -> repository.findByCedula(ced))
                .orElse(Optional.empty());
        if (resultCed.isPresent()){
            log.warn("La cedula ya se encuentra en el sistema");
            throw new CustomException("RegExist", "The Cedula already exists");
        }
        doctor.setCedula(data.getCedula());
        }

        if(data.getHospitalName() != null){
        Optional<Hospital> hospitalExist = Optional.ofNullable(data.getHospitalName())
                .map(hosp -> hospitalRepository.findByName(hosp))
                .orElse(Optional.empty());
        if(hospitalExist.isEmpty()){
            log.warn("El hospital no existe en BD proceda a crearlo");
            throw new CustomException("NoFound", "Hospital doesn't exist");

        }
        doctor.setHospital(hospitalExist.get());
        }

        if(data.getMedSpecial()!=null){
        Optional<MedicalSpeciality> medSp = Optional.ofNullable(data.getMedSpecial())
                .map(medS -> MedSpRepository.findByName(medS))
                .orElse(Optional.empty());
        if(medSp.isEmpty()){
            log.warn("La especialidad Medica no existe en BD proceda a crearlo");
            throw new CustomException("NoFound", "MedicalSpeciality doesn't exist");
        }
        doctor.setMedicalSpeciality(medSp.get());
        }

        doctor.setName(data.getName());
        log.info("metodo update() realizado con exito en doctorServiceImpl");
        repository.save(doctor);
      }

    public void updatePatch(long id, DoctorPatchDTO data) throws CustomException {
        Optional<Doctor> result = Optional.ofNullable(id)
                .map(doc -> repository.findById(doc))
                .orElse(Optional.empty());
        if (result.isEmpty()) {
            log.warn("Result vacio en findById en doctorServiceImpl");
            throw new CustomException("NoFound", "We can't found the Doctor: " + data.getName());
        }
        Doctor doctor = result.get();
        Optional<Hospital> hospitalExist = Optional.empty();
        if(data.getCedula() != null){
            Optional<Doctor> resultCed = Optional.ofNullable(data.getCedula())
                    .map(ced -> repository.findByCedula(ced))
                    .orElse(Optional.empty());
            if (resultCed.isPresent()){
                log.warn("La cedula ya se encuentra en el sistema");
                throw new CustomException("RegExist", "The Cedula already exists");
            }
            doctor.setCedula(data.getCedula());
        }
        String nameHospital = data.getHospitalName();
        if(nameHospital != null){
            hospitalExist = Optional.ofNullable(nameHospital)
                    .map(hosp -> hospitalRepository.findByName(hosp))
                    .orElse(Optional.empty());
            if(hospitalExist.isEmpty()){
                log.warn("El hospital no existe en BD proceda a crearlo");
                throw new CustomException("NoFound", "Hospital doesn't exist");

            }
            log.warn("Se coloca hospital de doctor a null para intentar eliminar relacion");
            doctor.setHospital(null);
            log.warn("hospital se coloco a null");
            doctor.setHospital(hospitalExist.get());
            log.warn("Se coloca nuevo hospital en campo hospital de doctor");
        }else{
            nameHospital = result.get().getHospital().getName();
        }
        Optional<MedicalSpeciality> medSp = Optional.empty();
        if(data.getMedSpecial()!=null){
            medSp = Optional.ofNullable(data.getMedSpecial())
                    .map(medS -> MedSpRepository.findByName(medS))
                    .orElse(Optional.empty());
            if(medSp.isEmpty()){
                log.warn("La especialidad Medica no existe en BD proceda a crearlo");
                throw new CustomException("NoFound", "MedicalSpeciality doesn't exist");
            }
            log.warn("Se coloca MedSP de doctor a null para intentar eliminar relacion");
            doctor.setMedicalSpeciality(null);
            log.warn("MedSp se coloco a null");
            doctor.setMedicalSpeciality(medSp.get());
            log.warn("Se coloca nueva especialidad en el campo MedSp de Doctor");
            //Se revisa si hospital tiene a la especialidad que se acaba de modificar
            hospitalExist = hospitalRepository.findByName(nameHospital);
            Optional<MedicalSpeciality> finalMedSp = medSp;
            List<MedicalSpeciality> MdSpList = hospitalExist.get().getMedicalSpecialities()
                  .stream()
                  .filter(Sp -> Sp.getName().startsWith(finalMedSp.get().getName()))
                  .collect(Collectors.toList());
                if (MdSpList.isEmpty()){
                    log.warn("No se encontro la especialidad" + finalMedSp.get().getName()+ "en Hospital" + hospitalExist.get().getName());
                    log.info("Se agrega especialidad a Hospital");
                    hospitalExist.get().getMedicalSpecialities().add(medSp.get());
                    log.info("Se guarda hospital ");
                    hospitalRepository.save(hospitalExist.get());
                    log.info("Hospital guardado");
                }

                log.info("Se revisa si el hospital"+" " +hospitalExist.get().getName() + "Existe en la especialidad "+ medSp.get().getName());

            Optional<Hospital> finalHospitalExist = hospitalExist;
            List<Hospital> hospList = medSp.get().getHospital()
                        .stream()
                        .filter(Hp -> Hp.getName().startsWith(finalHospitalExist.get().getName()))
                        .collect(Collectors.toList());

            if (hospList.isEmpty()){
                log.warn("No se encontro el hospital" + " "+hospitalExist.get().getName()+ "en la especialidad" +" "+ finalMedSp.get().getName() );
                log.info("Se agrega Hospital a Especialidad");
                medSp.get().getHospital().add(hospitalExist.get());
                log.info("Se guarda Especialidad ");
                MedSpRepository.save(medSp.get());
                log.info("Especialidad guardada");
            }
            }


        if(data.getName()!=null){
            Doctor nameDoc = repository.findByName(data.getName());
            if(nameDoc != null){
                log.warn("El doctor ya existe en la DB");
                throw new CustomException("NoFound", "Doctor already exists");
            }
            doctor.setName(data.getName());
        }

        log.info("metodo update() realizado con exito en doctorServiceImpl");
        repository.save(doctor);
    }
      public void delete(long id) throws Exception {
        Optional<Doctor> result = repository.findById(id);
    
        if (result.isEmpty()) {
          throw new Exception("the Doctor doesn't exist");
        }
        log.info("metodo delete() realizado con exito en doctorServiceImpl");
        repository.deleteById(id);
      }

    
}
