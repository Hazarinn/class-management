package com.example.crudAluno.services;

import com.example.crudAluno.entities.Estudante;

import com.example.crudAluno.handler.ResourceNotFoundException;
import com.example.crudAluno.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("estudante")
@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> buscaTodos() {
        return estudanteRepository.findAll();
    }

    public Estudante buscaPeloId(Long id) {
        return estudanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Aluno não encontrado para o id: %d", id)));
    }

    public Estudante createEstudante(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public Estudante estudanteUpdate(Long id, Estudante est) {
        Estudante estudante1 = buscaPeloId(id);
        estudante1.setNome(est.getNome());
        estudante1.setEndereco(est.getEndereco());
        estudante1.setEmail(est.getEmail());
        estudante1.setCpf(est.getCpf());
        estudante1.setTelefone(est.getTelefone());
        estudante1.setDisciplinas(est.getDisciplinas());
        return estudanteRepository.save(estudante1);
    }

    public void deleteEstudante(Long id) {
        if (estudanteRepository.existsById(id)) {
            estudanteRepository.deleteById(id); // Método correto para deletar por ID
        } else {
            throw new ResourceNotFoundException(String.format("Aluno não encontrado para o id: %d", id));
        }
    }
}
