package lara.pers.ProjectM2.dto;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO {
    
    private long id;

    @NotEmpty(message = "The Client must have a name")
    @NotNull(message = "The name not must be null")
    @Size(min = 3 ,max = 10, message = "The size name must be between 3 and 10 characters")
    private String name;


    @NotEmpty(message = "The Client must have an email")
    @NotNull(message = "The email not must be null")
    @Email(message = "the email is not valid format")
    @UniqueElements(message = "The ")
    private String email;

    @NotEmpty(message = "The password is mandatory")
    @NotNull(message = "The password not must be null")
    @Size(min=8, max=20, message="the length password must be between 8 and 20 characters")
    //@Pattern(regexp = "")
    private String password;

    
}
