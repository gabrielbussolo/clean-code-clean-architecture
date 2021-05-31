package dev.gabrielbussolo.domain;

public class Student {
    private String name;
    private Cpf cpf;

    public Student() {
    }

    public Student(String name, Cpf cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }
}
