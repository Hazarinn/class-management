package com.example.crudAluno.services;


import com.example.crudAluno.entities.Discipline;
import com.example.crudAluno.entities.Student;
import com.example.crudAluno.handler.ResourceNotFoundException;
import com.example.crudAluno.repositories.AddressRepository;
import com.example.crudAluno.repositories.DisciplineRepository;
import com.example.crudAluno.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Student> searchAll(){

        return studentRepository.findAll();
    }


    public Student searchById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("ALuno não encontrado para o id: %d", id)));

    }

    public Student createStudent(Student student){
        List<Discipline> disciplines = student.getDisciplines();
        student.setDisciplines(new ArrayList<>());

        for (Discipline discipline : disciplines) {
            discipline.setStudent(student);
            student.getDisciplines().add(discipline);
        }

        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student st){


        Student studentUpdate = searchById(id);
        studentUpdate.setName(st.getName());
        studentUpdate.setAddress(st.getAddress());
        studentUpdate.setEmail(st.getEmail());
        studentUpdate.setRegistration(st.getRegistration());
        studentUpdate.setTelephone(st.getTelephone());
        studentUpdate.setDisciplines(st.getDisciplines());

            return studentRepository.save(studentUpdate);
        }


    public void addDisciplineToStudent(Long studentId, Long disciplineId) {
        var student = searchById(studentId);
        var discipline = disciplineRepository.findById(disciplineId).orElseThrow(() -> new ResourceNotFoundException("Discipline not found"));
        if(student.getDisciplines().isEmpty()){
            student.getDisciplines().add(discipline);
        }
        student.getDisciplines();
        createStudent(student);
    }


    public void addAddressToStudent(Long studentId, Long addressId) {
        var student = searchById(studentId);
        var address = addressRepository.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        student.setAddress(student.getAddress());
        createStudent(student);
    }




    public void deleteStudent(Long id){
        studentRepository.deleteStudent(id);
    }


}
