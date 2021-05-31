package dev.gabrielbussolo.service;

import dev.gabrielbussolo.domain.Cpf;
import dev.gabrielbussolo.domain.Name;
import dev.gabrielbussolo.domain.Student;
import dev.gabrielbussolo.domain.dto.StudentDTO;
import dev.gabrielbussolo.exceptions.StudentAlreadyEnrolledException;

import java.util.ArrayList;
import java.util.List;

public class EnrollStudent {

    private final List<Student> students = new ArrayList<>();
    public void execute(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(new Name(studentDTO.getName()));
        student.setCpf(new Cpf(studentDTO.getCpf()));
        save(student);
    }

    private void save(Student student) {
        boolean alreadyExist = students.stream().anyMatch(student1 -> student1.getCpf().getCpf().equals(student.getCpf().getCpf()));
        if (alreadyExist){
            throw new StudentAlreadyEnrolledException("Enrollment with duplicated student is not allowed");
        }
        students.add(student);
    }
}
