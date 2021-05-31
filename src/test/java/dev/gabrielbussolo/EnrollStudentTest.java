package dev.gabrielbussolo;

import dev.gabrielbussolo.domain.Cpf;
import dev.gabrielbussolo.domain.Student;
import dev.gabrielbussolo.exceptions.InvalidCpfException;
import dev.gabrielbussolo.exceptions.InvalidNameException;
import dev.gabrielbussolo.exceptions.StudentAlreadyEnrolledException;
import dev.gabrielbussolo.service.EnrollStudent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnrollStudentTest {
    @Test
    @DisplayName("Should not enroll without valid student name")
    void validStudentName(){
        EnrollStudent enrollStudent = new EnrollStudent();
        Student student = new Student();
        student.setName("Gabriel");

        Exception exception = assertThrows(InvalidNameException.class, () -> enrollStudent.execute(student));
        assertEquals("Invalid student name", exception.getMessage());
    }

    @Test
    @DisplayName("Should not enroll student without a valid cpf")
    void validStudentCpf(){
        Student student = new Student();
        student.setName("Ana Silva");
        Exception exception = assertThrows(InvalidCpfException.class, () -> student.setCpf(new Cpf("832.081.519-35")));
        assertEquals("Invalid CPF", exception.getMessage());
    }

    @Test
    @DisplayName("Should not enroll duplicated student")
    void notSaveDuplicatedStudent(){
        EnrollStudent enrollStudent = new EnrollStudent();
        Student student = new Student();
        student.setName("Ana Silva");
        student.setCpf(new Cpf("832.081.519-34"));
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student);
        Exception exception = assertThrows(StudentAlreadyEnrolledException.class, () -> enrollStudent.execute(students));
        assertEquals("Enrollment with duplicated student is not allowed", exception.getMessage());
    }
}
