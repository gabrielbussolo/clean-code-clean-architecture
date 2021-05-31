package dev.gabrielbussolo.service;

import dev.gabrielbussolo.domain.Cpf;
import dev.gabrielbussolo.domain.Student;
import dev.gabrielbussolo.exceptions.InvalidCpfException;
import dev.gabrielbussolo.exceptions.InvalidNameException;
import dev.gabrielbussolo.exceptions.StudentAlreadyEnrolledException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnrollStudent {

    private final Set<Student> students = new HashSet<>();
    public void execute(Student student) {
        validateStudentName(student.getName());
        save(student);
    }

    private void save(Student student) {
        if (students.contains(student)){
            throw new StudentAlreadyEnrolledException("Enrollment with duplicated student is not allowed");
        }
        students.add(student);
    }

    public void execute(List<Student> students){
        for (Student student:students) {
            execute(student);
        }
    }
    private void validateStudentName(String name){
        Pattern namePattern = Pattern.compile("^([A-Za-z]+ )+([A-Za-z])+$");
        Matcher validName = namePattern.matcher(name);
        if (!validName.find()){
            throw new InvalidNameException("Invalid student name");
        }
    }

}
