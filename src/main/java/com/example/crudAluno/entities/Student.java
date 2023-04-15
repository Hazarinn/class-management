package com.example.crudAluno.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Students")
@Entity(name = "Student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String telephone;
    private String registration;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("student")
    private List<Discipline> disciplines = new ArrayList<>();






    @OneToOne(cascade = CascadeType.ALL)
    private Address address;



}
