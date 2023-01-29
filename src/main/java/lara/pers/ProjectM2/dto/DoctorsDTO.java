package lara.pers.ProjectM2.dto;


import lara.pers.ProjectM2.entity.MedicalSpeciality;
import lombok.Data;

@Data
public class DoctorsDTO {
    private long id;
    private String name;
    private long PL;
    private MedicalSpeciality medicalSpeciality;
    
}
