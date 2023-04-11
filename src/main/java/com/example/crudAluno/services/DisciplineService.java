package com.example.crudAluno.services;

import com.example.crudAluno.entities.Discipline;
import com.example.crudAluno.entities.Student;
import com.example.crudAluno.repositories.DisciplineRepository;
import com.example.crudAluno.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {


    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Discipline> searchAll(){
        return disciplineRepository.findAll();
    }


    public Discipline searchById(Long id) {
        return disciplineRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("disciplina não encontrada para o id: %d", id)));

    }

    public Discipline createDiscipline(Discipline discipline){
        return disciplineRepository.save(discipline);
    }

    public Discipline updateDiscipline(Long id, Discipline disc){


        Discipline disciplineUpdate = searchById(id);
        disciplineUpdate.setName(disc.getName());
        disciplineUpdate.setDescription(disc.getDescription());
        disciplineUpdate.setStudent(disc.getStudent());


        return disciplineRepository.save(disciplineUpdate);
    }


    public void deleteStudent(Long id){
        disciplineRepository.deleteDiscipline(id);
    }
}
