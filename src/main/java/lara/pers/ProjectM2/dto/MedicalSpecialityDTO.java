package lara.pers.ProjectM2.dto;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MedicalSpecialityDTO {
    private long id;

    @NotEmpty(message = "The Speciality must have a name")
    @NotNull(message = "The name speciality not must be null")
    @Size(min = 3, max = 20, message = "The size of name hospital must be between 3 and 20 characters")
    private String name;

    @NotEmpty(message = "The speciality must have an info")
    @NotNull(message = "The info hospital not must be null")
    @Size(min = 10, max = 140, message = "The size of name hospital must be between 3 and 20 characters")
    private String info;

    
    private String schedule;
    
   
    
}
