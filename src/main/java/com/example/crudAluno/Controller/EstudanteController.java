package com.example.crudAluno.Controller;


import com.example.crudAluno.entities.Estudante;


import com.example.crudAluno.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;



    @GetMapping("/{id}")
    public Estudante getEstudanteById(@PathVariable("id") Long id){
        return estudanteService.buscaPeloId(id);

    }

    @GetMapping
    public List<Estudante> listaTodos(){
        return estudanteService.buscaTodos();
    }


    @PostMapping
    public Estudante criaEstudante(@RequestBody Estudante estudante){



        return estudanteService.createEstudante(estudante);
    }





    @PutMapping("/{id}")
    public Estudante atualizaEstudante(@PathVariable("id") Long id, @RequestBody Estudante estudante){
        return estudanteService.estudanteUpdate(id, estudante);
    }


    @DeleteMapping("/{id}")
    public void deletaEstudante(@PathVariable("id") Long id){
        estudanteService.deleteEstudante(id);
    }

}
