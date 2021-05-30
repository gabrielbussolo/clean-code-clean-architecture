package dev.gabrielbussolo;

import dev.gabrielbussolo.domain.Student;
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
}
