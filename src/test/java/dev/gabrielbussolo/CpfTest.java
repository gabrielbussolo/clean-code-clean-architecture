package dev.gabrielbussolo;

import dev.gabrielbussolo.domain.Cpf;
import dev.gabrielbussolo.exceptions.InvalidCpfException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CpfTest {
    @Test
    @DisplayName("Should not accept cpf with equal numbers")
    void equalNumbers(){
        InvalidCpfException invalidCpfException = Assertions.assertThrows(InvalidCpfException.class, () -> new Cpf("111.111.111-11"));
        assertEquals("Invalid CPF", invalidCpfException.getMessage());
    }
    @Test
    @DisplayName("Should not accept cpf with invalid size")
    void isInvalidSize(){
        InvalidCpfException invalidCpfException = Assertions.assertThrows(InvalidCpfException.class, () -> new Cpf("111.111.111"));
        assertEquals("Invalid CPF", invalidCpfException.getMessage());
    }
    @Test
    @DisplayName("Should accept valid cpf")
    void validCpf(){
        Assertions.assertDoesNotThrow(() -> new Cpf("86446422784"));
        Assertions.assertDoesNotThrow(() -> new Cpf("864.464.227-84"));
    }
}
