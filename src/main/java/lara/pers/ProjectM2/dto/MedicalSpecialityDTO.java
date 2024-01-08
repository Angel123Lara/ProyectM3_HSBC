package lara.pers.ProjectM2.dto;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class MedicalSpecialityDTO {
    private long id;

    private String name;

    private String info;

    private String schedule;

    private List<DoctorSimpleGetDTO> doctor;

    private List<HospitalSimpleGetDTO> hospital;
    
   
    
}
