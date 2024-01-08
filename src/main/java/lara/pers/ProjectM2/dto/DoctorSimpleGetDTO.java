package lara.pers.ProjectM2.dto;

import lara.pers.ProjectM2.entity.MedicalSpeciality;
import lombok.Data;

@Data
public class DoctorSimpleGetDTO {
    private long id;

    private String name;

    private String cedula;

    private MedSpecialSimpleGetDTO medicalSpeciality;

}
