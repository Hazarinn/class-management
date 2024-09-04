package com.example.crudAluno.entities;



import lombok.*;

import javax.persistence.*;

@Table(name = "Enderecos")
@Entity(name = "Endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;


}
