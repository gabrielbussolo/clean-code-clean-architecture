package dev.gabrielbussolo.domain;

import dev.gabrielbussolo.exceptions.InvalidNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    private String name;

    public Name(String name){
        if (!validateName(name))
            throw new InvalidNameException("Invalid name");
        this.name = name;
    }

    private boolean validateName(String name){
        Pattern namePattern = Pattern.compile("^([A-Za-z]+ )+([A-Za-z])+$");
        Matcher validName = namePattern.matcher(name);
        return validName.find();
    }
}
