package lara.pers.ProjectM2.dto;

import com.fasterxml.jackson.annotation.JsonMerge;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class DoctorPatchDTO {
    @JsonMerge
    private String name;
    private String cedula;
    private String hospitalName;
    private String medSpecial;

}
