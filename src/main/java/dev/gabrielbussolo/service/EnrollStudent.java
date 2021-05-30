package dev.gabrielbussolo.service;

import dev.gabrielbussolo.domain.Student;
import dev.gabrielbussolo.exceptions.InvalidNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnrollStudent {
    public void execute(Student student) {
        validateStudentName(student.getName());
    }
    private void validateStudentName(String name){
        Pattern namePattern = Pattern.compile("^([A-Za-z]+ )+([A-Za-z])+$");
        Matcher matcher = namePattern.matcher(name);
        if (!matcher.find()){
            throw new InvalidNameException("Invalid student name");
        }
    }
}
