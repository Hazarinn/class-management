package com.example.crudAluno.repositories;

import com.example.crudAluno.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.id =:id")
    Student getById(@Param("id")Long id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM students s WHERE s.id = ?1", nativeQuery = true)
    void deleteStudent(@Param("id")Long id);
}
