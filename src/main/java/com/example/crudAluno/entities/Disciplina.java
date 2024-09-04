package com.example.crudAluno.entities;

import lombok.*;

import javax.persistence.*;

@Table(name = "Disciplinas")

@Entity(name = "Disciplina")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of ="id")
public class Disciplina {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;


    @ManyToOne
    @JoinColumn(name="estudante_id")
    private Estudante estudante;



}
