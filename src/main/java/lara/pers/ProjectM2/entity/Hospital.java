package lara.pers.ProjectM2.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

import lara.pers.ProjectM2.dto.DoctorDTO;
import lara.pers.ProjectM2.dto.DoctorSimpleGetDTO;
import lara.pers.ProjectM2.dto.MedSpecialSimpleGetDTO;
import lombok.Data;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.hateoas.mediatype.alps.Doc;

@Data
@Entity
@Table(name = "Hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;


    
    @Column(name = "direccion",nullable = false)
    private String address;

    
    @Column(name = "Telefono")
    private String phone;

    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Doctor> doctors;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(
            name = "hospital_medical_speciality",
            joinColumns = @JoinColumn(name = "hospital_name"),
            inverseJoinColumns = @JoinColumn(name = "medical_speciality_name")
    )
    private List<MedicalSpeciality> medicalSpecialities;

}
