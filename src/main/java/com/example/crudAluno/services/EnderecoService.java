package com.example.crudAluno.services;



import com.example.crudAluno.entities.Endereco;
import com.example.crudAluno.handler.ResourceNotFoundException;
import com.example.crudAluno.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> listarTodos(){
        return enderecoRepository.findAll();
    }


    public Optional<Endereco> BuscaPeloId(Long id) {
       return enderecoRepository.findById(id);
    }

    public Endereco criaEndereco(Endereco endereco){

        return enderecoRepository.save(endereco);
    }




    public Endereco atualizaEndereco(Long id, Endereco end){



        Endereco attEndereco = BuscaPeloId(id).orElseThrow(() -> new RuntimeException(String.format("Endereço não encontrado para o id %d", id)));

        attEndereco.setCidade(end.getCidade());
        attEndereco.setEstado(end.getEstado());
        attEndereco.setCep(end.getCep());
        attEndereco.setPais(end.getPais());


        return enderecoRepository.save(attEndereco);
    }

    public void deletarEndereco(Long id){
        if(enderecoRepository.existsById(id)){
            enderecoRepository.deletaEndereco(id);
        }else {
            throw new ResourceNotFoundException(String.format("Endereco não encontrado para o id: %d", id));
        }


    }
}
