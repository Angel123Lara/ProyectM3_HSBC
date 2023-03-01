package lara.pers.ProjectM2.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HospitalDTO {
    private long id;

    @NotEmpty(message = "The hospital must have a name")
    @NotNull(message = "The name hospital not must be null")
    @Size(min = 3, max = 20, message = "The size of name hospital must be between 3 and 20 characters")
    private String name;

    @NotEmpty(message = "The hospital must have an address")
    @NotNull(message = "The address hospital not must be null")
    @Size(min = 5, max = 30, message = "The size of address hospital must be between 5 and 30 characters")
    private String address;

    @Pattern(regexp = "[1-9]{1}[0-9]{9}", message = "the phone must be a valid number phone")
    @NotEmpty(message = "The hospital must have an phone")
    @NotNull(message = "The phone hospital not must be null")    
    //@Size(min = 1000000000, max = 9999999999L, message = "The number phone must be 10 digits")
    
    private String phone;
    
}
