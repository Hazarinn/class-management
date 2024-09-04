package com.example.crudAluno.repositories;

import com.example.crudAluno.entities.Estudante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    @Query("SELECT s FROM Estudante s WHERE s.id =:id")
    Estudante getById(@Param("id")Long id);


    @Modifying
    @Query(value = "DELETE FROM estudantes s WHERE s.id = ?1", nativeQuery = true)
    void deleteEstudante(@Param("id")Long id);
}
