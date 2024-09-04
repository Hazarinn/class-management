package com.example.crudAluno.Controller;




import com.example.crudAluno.entities.Disciplina;
import com.example.crudAluno.services.DisciplinaService;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value ="/disciplina")
public class DisciplinaController {


    @Autowired
    private DisciplinaService disciplinaService;


    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getById(@PathVariable("id") Long id) {

        Optional<Disciplina> optionalDisciplina = disciplinaService.searchById(id);

        return optionalDisciplina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }


    @GetMapping
    public ResponseEntity<List<Disciplina>> getAll() {
        List<Disciplina> disciplinas = disciplinaService.searchAll();


        return new ResponseEntity<>(disciplinas, OK);


    }

    @PostMapping
    public ResponseEntity<Disciplina> registerDiscipline(@RequestBody Disciplina disciplina) {
        Disciplina disc = disciplinaService.createDisciplina(disciplina);

        return new ResponseEntity<>(disc, CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> alterDisciplina(@PathVariable("id") Long id, @RequestBody Disciplina disciplina) {
        Disciplina disciplinaAtualizada = disciplinaService.updateDisciplina(id, disciplina);

        return ResponseEntity.ok(disciplinaAtualizada);


    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable("id") Long id) {

        disciplinaService.searchById(id);

        return ResponseEntity.status(NOT_FOUND).build();
    }

}
