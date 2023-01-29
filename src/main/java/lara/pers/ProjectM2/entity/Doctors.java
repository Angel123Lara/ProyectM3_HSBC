package lara.pers.ProjectM2.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Doctors")
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "PL",nullable = false)
    private  long PL;

    //agregar aqui relacion con la tabla de especialidad

    @ManyToOne
    @JoinColumn(name = "Speciality",referencedColumnName = "id")
    private MedicalSpeciality medicalSpeciality;
    
}
