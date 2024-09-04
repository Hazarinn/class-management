package com.example.crudAluno.Controller;



import static org.springframework.http.HttpStatus.*;

import com.example.crudAluno.entities.Disciplina;
import com.example.crudAluno.entities.Endereco;
import com.example.crudAluno.services.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value="/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> listaTodos(){
        List<Endereco> enderecos = enderecoService.listarTodos();


        return new ResponseEntity<>(enderecos, OK);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscaPorId(@PathVariable("id") Long id){

        Optional<Endereco> optionalEndereco = enderecoService.BuscaPeloId(id);
        return optionalEndereco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());


    }


    @PostMapping
    public ResponseEntity<Endereco> criaEndereco(@RequestBody Endereco endereco){
        Endereco end = enderecoService.criaEndereco(endereco);

            return new ResponseEntity<>(endereco, CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizaEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco){
        Endereco end =  enderecoService.atualizaEndereco(id, endereco);

        return ResponseEntity.ok(endereco);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaEndereco(@PathVariable Long id){
        enderecoService.deletarEndereco(id);

        return ResponseEntity.status(NOT_FOUND).build();
    }

}
