package lara.pers.ProjectM2.dto;


import lombok.Data;

@Data
public class DoctorDTO {
    
    private long id;

    private String name;

    private String cedula;

    private HospitalSimpleGetDTO hospital;

    private MedSpecialSimpleGetDTO medicalSpeciality;


}
