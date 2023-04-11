package com.example.crudAluno.entities;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "Addresses")
@Entity(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Address {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    @OneToOne
    private Student student;
}
