package dev.gabrielbussolo.domain;

public class Student {
    private Name name;
    private Cpf cpf;

    public Student() {
    }

    public Student(Name name, Cpf cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }
}
