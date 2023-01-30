package lara.pers.ProjectM2.entity;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
@Table(name ="Clientes")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Usuario must have a name")
    @NotNull(message = "The name not must be null")
    @Size(min = 3 ,max = 10, message = "The size name must be between 3 and 10 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "The User must have an email")
    @NotNull(message = "The email not must be null")
    @Email(message = "the email is not valid format")
    @UniqueElements(message = "The ")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "The password is mandatory")
    @NotNull(message = "The password not must be null")
    @Size(min=8, max=20, message="the length password must be between 8 and 20 characters")
    
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty(message = "The rol must have an email")
    @NotNull(message = "The rol not must be null")
    @Column(name="rol", nullable = false)
    private String rol;

    

}
