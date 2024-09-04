package com.example.crudAluno.services;



import com.example.crudAluno.entities.Endereco;
import com.example.crudAluno.handler.ResourceNotFoundException;
import com.example.crudAluno.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> SearchAll(){
        return enderecoRepository.findAll();
    }

    public Endereco searchById(Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Endereço não encontrado para o id: %d", id)));

    }

    public Endereco createEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }


    public Endereco updateEndereco(Long id, Endereco end){


        Endereco updateEndereco = searchById(id);
        updateEndereco.setCidade(end.getCidade());
        updateEndereco.setEstado(end.getEstado());
        updateEndereco.setCep(end.getCep());
        updateEndereco.setPais(end.getPais());


        return enderecoRepository.save(updateEndereco);
    }

    public void deleteEndereco(Long id){
        if(enderecoRepository.existsById(id)){
            enderecoRepository.deleteAdress(id);
        }else {
            throw new ResourceNotFoundException(String.format("Endereco não encontrado para o id: %d", id));
        }


    }
}
