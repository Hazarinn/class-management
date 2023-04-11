package com.example.crudAluno.alunoController;




import com.example.crudAluno.entities.Discipline;
import com.example.crudAluno.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/discipline")
public class DisciplineController {


    @Autowired
    private DisciplineService disciplineService;


    @GetMapping("/{id}")
    public Discipline getById(@PathVariable("id") Long id){
        return disciplineService.searchById(id);

    }

    @GetMapping
    public List<Discipline> getAll(){
        return disciplineService.searchAll();
    }

    @PostMapping
    public Discipline registerDiscipline(@RequestBody Discipline discipline){
        return disciplineService.createDiscipline(discipline);
    }

    @PutMapping("/{id}")
    public Discipline alterDiscipline(@PathVariable("id") Long id, @RequestBody Discipline discipline){
        return disciplineService.updateDiscipline(id,discipline);
    }


    @DeleteMapping
    public void deleteDiscipline(@PathVariable("id") Long id){
        disciplineService.deleteStudent(id);
    }

}
