package lara.pers.ProjectM2.dto;

import lara.pers.ProjectM2.entity.Doctor;
import lombok.Data;

import java.util.List;

@Data
public class HospitalDTO {

    private long id;

    private String name;

    private String address;

    private String phone;

    private List<DoctorSimpleGetDTO> doctors;

    private List<MedSpecialSimpleGetDTO> medicalSpecialities;
}
