package com.example.crudAluno.repositories;

import com.example.crudAluno.entities.Endereco;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT ad FROM Endereco ad WHERE ad.id =:id")
    Endereco getAddressById(@Param("id")Long id);


    @Modifying

    @Query(value = "DELETE FROM enderecos ad WHERE ad.id = ?1", nativeQuery = true)
    void deleteAdress(@Param("id")Long id);

}
