package com.example.crudAluno.services;

import com.example.crudAluno.entities.Estudante;

import com.example.crudAluno.handler.ResourceNotFoundException;
import com.example.crudAluno.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<Estudante> buscaTodos() {
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> buscaPeloId(Long id) {
        return estudanteRepository.findById(id);

    }

    public Estudante createEstudante(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public Estudante estudanteUpdate(Long id, Estudante est) {

        Estudante estudanteAtualizado = buscaPeloId(id).orElseThrow(() -> new RuntimeException(String.format("Estudante não encontrado para o id: %d", id)));
        estudanteAtualizado.setNome(est.getNome());
        estudanteAtualizado.setEndereco(est.getEndereco());
        estudanteAtualizado.setEmail(est.getEmail());
        estudanteAtualizado.setCpf(est.getCpf());
        estudanteAtualizado.setTelefone(est.getTelefone());
        estudanteAtualizado.setDisciplinas(est.getDisciplinas());
        return estudanteRepository.save(estudanteAtualizado);
  }

        public void deletaEstudante (Long id) {
            if (estudanteRepository.existsById(id)) {
                estudanteRepository.deleteById(id); // Método correto para deletar por ID
            } else {
                throw new ResourceNotFoundException(String.format("Aluno não encontrado para o id: %d", id));
            }

        }
        }

