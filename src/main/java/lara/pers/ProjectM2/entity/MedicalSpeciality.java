package lara.pers.ProjectM2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Data
@Entity
@Table(name="MedicalSpeciality")
public class MedicalSpeciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;
   
    @Column(name ="info", nullable = false)
    private String info;

    @Column(name = "Schedule")
    private String schedule;

   
}
