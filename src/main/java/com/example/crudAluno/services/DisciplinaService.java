package com.example.crudAluno.services;

import com.example.crudAluno.entities.Disciplina;
import com.example.crudAluno.handler.ResourceNotFoundException;
import com.example.crudAluno.repositories.DisciplinaRepository;
import com.example.crudAluno.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {


    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Disciplina> searchAll(){
        return disciplinaRepository.findAll();
    }


    public Optional<Disciplina> searchById(Long id) {


        return disciplinaRepository.findById(id);

    }

    public Disciplina createDisciplina(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina updateDisciplina(Long id, Disciplina disc) {
        // Busca a Disciplina pelo ID
        Disciplina disciplinaExistente = searchById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Disciplina não encontrada para o id: %d", id)));

        // Atualiza os campos da Disciplina existente com os valores novos
        disciplinaExistente.setNome(disc.getNome());
        disciplinaExistente.setDescricao(disc.getDescricao());
        disciplinaExistente.setEstudante(disc.getEstudante());

        // Salva e retorna a Disciplina atualizada
        return disciplinaRepository.save(disciplinaExistente);
    }


    public void deleteDisciplina(Long id){
        if (disciplinaRepository.existsById(id)){

            disciplinaRepository.deleteDisciplina(id);
        }else {
            throw new ResourceNotFoundException(String.format("Disciplina não encontrada para o id: %d", id));
        }


    }





}
