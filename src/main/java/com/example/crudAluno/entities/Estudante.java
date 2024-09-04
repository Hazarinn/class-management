package com.example.crudAluno.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Estudantes")
@Entity(name = "Estudante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Estudante {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("estudante")
    private List<Disciplina> disciplinas = new ArrayList<>();






    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;



}
