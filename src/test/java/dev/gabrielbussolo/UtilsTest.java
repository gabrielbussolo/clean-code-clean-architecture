package dev.gabrielbussolo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    @DisplayName("Should not accept cpf with equal numbers")
    void equalNumbers(){
        Assertions.assertFalse(Utils.validCpf("111.111.111-11"));
    }
    @Test
    @DisplayName("Should not accept cpf with invalid size")
    void isInvalidSize(){
        Assertions.assertFalse(Utils.validCpf("111.111.111"));
    }
    @Test
    @DisplayName("Should accept valid cpf")
    void validCpf(){
        Assertions.assertTrue(Utils.validCpf("86446422784"));
        Assertions.assertTrue(Utils.validCpf("864.464.227-84"));
    }
}
