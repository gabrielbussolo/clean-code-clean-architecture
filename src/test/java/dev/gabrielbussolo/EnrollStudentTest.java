package dev.gabrielbussolo;

import dev.gabrielbussolo.domain.dto.StudentDTO;
import dev.gabrielbussolo.exceptions.InvalidCpfException;
import dev.gabrielbussolo.exceptions.InvalidNameException;
import dev.gabrielbussolo.exceptions.StudentAlreadyEnrolledException;
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
        StudentDTO student = new StudentDTO();
        student.setName("Gabriel");
        student.setCpf("832.081.519-35");

        Exception exception = assertThrows(InvalidNameException.class, () -> enrollStudent.execute(student));
        assertEquals("Invalid name", exception.getMessage());
    }

    @Test
    @DisplayName("Should not enroll student without a valid cpf")
    void validStudentCpf(){
        EnrollStudent enrollStudent = new EnrollStudent();
        StudentDTO student = new StudentDTO();
        student.setName("Ana Silva");
        student.setCpf("832.081.519-35");
        Exception exception = assertThrows(InvalidCpfException.class, () -> enrollStudent.execute(student));
        assertEquals("Invalid CPF", exception.getMessage());
    }

    @Test
    @DisplayName("Should not enroll duplicated student")
    void notSaveDuplicatedStudent(){
        EnrollStudent enrollStudent = new EnrollStudent();
        StudentDTO student = new StudentDTO();
        student.setName("Ana Silva");
        student.setCpf("832.081.519-34");
        enrollStudent.execute(student);
        Exception exception = assertThrows(StudentAlreadyEnrolledException.class, () -> enrollStudent.execute(student));
        assertEquals("Enrollment with duplicated student is not allowed", exception.getMessage());
    }
}
