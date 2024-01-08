package lara.pers.ProjectM2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorOnEntityDTO {
    private long id;

    @NotEmpty(message = "Doctor must have a name")
    @NotNull(message = "The name not must be null")
    @Size(min = 3 ,max = 20, message = "The size name must be between 3 and 10 characters")
    private String name;

    @NotNull(message = "The cedula field not must be null")
    @NotEmpty(message = "tha cedula is required")
    @Pattern(regexp = "[A-Z]{2}[0-9]{4}",message = "Format is invalid for cedula, the Cedula must be AA####")
    private String cedula;
    private String hospitalName;
    private String nameMedSpecial;

}
