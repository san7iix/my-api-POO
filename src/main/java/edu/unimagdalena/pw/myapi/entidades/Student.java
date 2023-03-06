package edu.unimagdalena.pw.myapi.entidades;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="students")
@NoArgsConstructor
public class Student {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    @Column (nullable = false)
    private String lastName;
    @Column (nullable = false)
    private String firtName;
    @Column (nullable = false, unique=true)
    private String codigo;
    @Column
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

}
