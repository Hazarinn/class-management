package com.example.crudAluno.Controller;


import com.example.crudAluno.entities.Estudante;


import com.example.crudAluno.services.EstudanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;



    @GetMapping("/{id}")
    public ResponseEntity<Estudante>getEstudanteById(@PathVariable("id") Long id){

        Optional<Estudante> optionalEstudante = estudanteService.buscaPeloId(id);

        return  optionalEstudante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<Estudante>> listaTodos(){
        List<Estudante> estudantes = estudanteService.buscaTodos();
        return new ResponseEntity<>(estudantes, OK);
    }


    @PostMapping
    public ResponseEntity<Estudante> criaEstudante(@RequestBody Estudante estudante){

        Estudante est = estudanteService.createEstudante(estudante);


        return new ResponseEntity<>(est, CREATED);
    }





    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizaEstudante(@PathVariable("id") Long id, @RequestBody Estudante estudante){

        Estudante est = estudanteService.estudanteUpdate(id, estudante);
        return  ResponseEntity.ok(est);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaEstudante(@PathVariable("id") Long id){

        estudanteService.buscaPeloId(id);
        return ResponseEntity.status(NOT_FOUND).build();

    }

}
