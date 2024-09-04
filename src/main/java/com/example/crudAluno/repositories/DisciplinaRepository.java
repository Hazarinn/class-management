package com.example.crudAluno.repositories;

import com.example.crudAluno.entities.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {


    @Query("SELECT d FROM Disciplina d WHERE d.id =:id")
    Disciplina getDisciplinaById(@Param("id")Long id);


    @Modifying
    @Query(value = "DELETE FROM disciplinas d WHERE d.id = ?1", nativeQuery = true)
    void deleteDisciplina(@Param("id")Long id);


}
