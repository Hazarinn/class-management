package com.example.crudAluno.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Disciplines")

@Entity(name = "Discipline")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Discipline {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
