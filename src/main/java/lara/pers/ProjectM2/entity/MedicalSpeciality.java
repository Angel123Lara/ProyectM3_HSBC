package lara.pers.ProjectM2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

import lara.pers.ProjectM2.dto.DoctorOnEntityDTO;
import lara.pers.ProjectM2.dto.HospitalSimpleGetDTO;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@Table(name="MedicalSpeciality")
public class MedicalSpeciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", unique = true)
    private String name;
   
    @Column(name ="info")
    private String info;

    @Column(name = "Schedule")
    private String schedule;

    @OneToMany(mappedBy = "medicalSpeciality")
    private List<Doctor> doctor;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinTable(
            name = "medical_speciality_hospital",
            joinColumns = @JoinColumn(name = "medical_speciality_name"),
            inverseJoinColumns = @JoinColumn(name = "hospital_name"))
    private List<Hospital> hospital;
    //@ManyToMany(fetch = FetchType.LAZY,mappedBy = "medicalSpecialities")
    //private List<Hospital> hospital;
   
}
