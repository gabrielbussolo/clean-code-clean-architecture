package dev.gabrielbussolo.service;

import dev.gabrielbussolo.Utils;
import dev.gabrielbussolo.domain.Student;
import dev.gabrielbussolo.exceptions.InvalidCpfException;
import dev.gabrielbussolo.exceptions.InvalidNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnrollStudent {
    public void execute(Student student) {
        validateStudentName(student.getName());
        validateStudentCpf(student.getCpf());
    }

    private void validateStudentCpf(String cpf) {
        boolean valid = Utils.validCpf(cpf);
        if (!valid){
            throw new InvalidCpfException("Invalid student CPF");
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
