package com.example.crudAluno.alunoController;

import com.example.crudAluno.entities.Discipline;
import com.example.crudAluno.entities.Student;
import com.example.crudAluno.services.DisciplineService;
import com.example.crudAluno.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/student")
public class StudentController {

    @Autowired
    private StudentService studentService;




    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return studentService.searchById(id);

    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.searchAll();
    }

    @PostMapping
    public Student registerStudent(@RequestBody Student student){


        return studentService.createStudent(student);
    }

    @PostMapping("/{studentId}/disciplines/{disciplineId}")
    public void addDisciplineToStudent(@PathVariable Long studentId, @PathVariable Long disciplineId) {
        studentService.addDisciplineToStudent(studentId, disciplineId);


    }

    @PostMapping("/{studentId}/addresses/{addressId}")
    public void addAddressToStudent(@PathVariable Long studentId, @PathVariable Long addressId) {
        studentService.addAddressToStudent(studentId, addressId);


    }



    @PutMapping("/{id}")
    public Student alterStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }


    @DeleteMapping
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
    }

}
