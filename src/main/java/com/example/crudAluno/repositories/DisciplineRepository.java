package com.example.crudAluno.repositories;

import com.example.crudAluno.entities.Discipline;
import com.example.crudAluno.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {


    @Query("SELECT d FROM Discipline d WHERE d.id =:id")
    Discipline getDisciplineById(@Param("id")Long id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM disciplines d WHERE d.id = ?1", nativeQuery = true)
    void deleteDiscipline(@Param("id")Long id);


}
