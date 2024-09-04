package com.example.crudAluno.Controller;



import com.example.crudAluno.entities.Endereco;
import com.example.crudAluno.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;


    @GetMapping
    public List<Endereco> getEnderecos(){
        return enderecoService.SearchAll();
    }


    @PostMapping
    public Endereco criarEndereco(@RequestBody Endereco endereco){
        return enderecoService.createEndereco(endereco);
    }

    @PutMapping("/{id}")
    public Endereco editaEndereco(@PathVariable("id") Long id, @RequestBody Endereco end){

        return enderecoService.updateEndereco(id, end);

    }

    @DeleteMapping("/{id}")
    public void deletaEndereco(@PathVariable Long id){
        enderecoService.deleteEndereco(id);
    }

}
