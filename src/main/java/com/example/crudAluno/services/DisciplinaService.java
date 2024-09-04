package com.example.crudAluno.services;

import com.example.crudAluno.entities.Disciplina;
import com.example.crudAluno.handler.ResourceNotFoundException;
import com.example.crudAluno.repositories.DisciplinaRepository;
import com.example.crudAluno.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {


    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Disciplina> searchAll(){
        return disciplinaRepository.findAll();
    }


    public Disciplina searchById(Long id) {
        return disciplinaRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("disciplina não encontrada para o id: %d", id)));

    }

    public Disciplina createDisciplina(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina updateDisciplina(Long id, Disciplina disc){


        Disciplina disciplinaUpdate = searchById(id);



         disciplinaUpdate.setNome(disc.getNome());
         disciplinaUpdate.setDescricao(disc.getDescricao());
         disciplinaUpdate.setEstudante(disc.getEstudante());


        return disciplinaRepository.save(disciplinaUpdate);
    }


    public void deleteEstudante(Long id){
        if (disciplinaRepository.existsById(id)){

            disciplinaRepository.deleteDisciplina(id);
        }else {
            throw new ResourceNotFoundException(String.format("Disciplina não encontrada para o id: %d", id));
        }


    }





}
