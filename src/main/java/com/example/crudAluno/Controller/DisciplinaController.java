package com.example.crudAluno.Controller;




import com.example.crudAluno.entities.Disciplina;
import com.example.crudAluno.services.DisciplinaService;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@RequestMapping(value ="/disciplina")
public class DisciplinaController {


    @Autowired
    private DisciplinaService disciplinaService;





    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getById(@PathVariable("id") Long id){

        Disciplina disc = disciplinaService.searchById(id);

        if (disc != null) {
            return new ResponseEntity<>(disc, OK);

        }

        return  new ResponseEntity<>( NOT_FOUND);


    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> getAll(){
        List<Disciplina> disciplinas = disciplinaService.searchAll();


        return new ResponseEntity<>(disciplinas, OK);


    }

    @PostMapping
    public ResponseEntity<Disciplina> registerDiscipline(@RequestBody Disciplina disciplina){
        Disciplina disc = disciplinaService.createDisciplina(disciplina);

           return new ResponseEntity<>(disc, CREATED);

    }

    @PutMapping("/{id}")
    public Disciplina alterDisciplina(@PathVariable("id") Long id, @RequestBody Disciplina disciplina){
        return disciplinaService.updateDisciplina(id, disciplina);
    }


    @DeleteMapping("/{id}")
    public void deleteDiscipline(@PathVariable("id") Long id){



            disciplinaService.deleteEstudante(id);


    }

}
