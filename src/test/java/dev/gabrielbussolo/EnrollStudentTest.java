package dev.gabrielbussolo;

import dev.gabrielbussolo.domain.Student;
import dev.gabrielbussolo.exceptions.InvalidCpfException;
import dev.gabrielbussolo.exceptions.InvalidNameException;
import dev.gabrielbussolo.service.EnrollStudent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        EnrollStudent enrollStudent = new EnrollStudent();
        Student student = new Student();
        student.setName("Ana Silva");
        student.setCpf("832.081.519-35");

        Exception exception = assertThrows(InvalidCpfException.class, () -> enrollStudent.execute(student));
        assertEquals("Invalid student CPF", exception.getMessage());
    }
}
