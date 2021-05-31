package dev.gabrielbussolo.domain;

import dev.gabrielbussolo.exceptions.InvalidCpfException;

import java.util.Arrays;

public class Cpf {

    private static final Integer FACTOR_DIGIT_1 = 10;
    private static final Integer FACTOR_DIGIT_2 = 11;
    private static final Integer MAX_DIGITS_1 = 9;
    private static final Integer MAX_DIGITS_2 = 10;

    private String cpf;

    public Cpf(String cpf) {
        if (!validCpf(cpf))
            throw new InvalidCpfException("Invalid CPF");
        this.cpf = cpf;
    }

    public boolean validCpf(String cpf){
        cpf = extractDigits(cpf);
        if (isInvalidLength(cpf)) return false;
        if (isBlocked(cpf)) return false;
        Integer digit1 = calculateDigit(cpf, FACTOR_DIGIT_1, MAX_DIGITS_1);
        Integer digit2 = calculateDigit(cpf, FACTOR_DIGIT_2, MAX_DIGITS_2);
        String calculatedCheckDigit = ""+digit1+digit2;
        return getCheckDigit(cpf).equals(calculatedCheckDigit);
    }

    private String extractDigits(String cpf) {
        return cpf.replaceAll("\\D", "");
    }

    private boolean isInvalidLength(String cpf) {
        return cpf.length() != 11;
    }

    private boolean isBlocked(String cpf) {
        String[] split = cpf.split("");
        return Arrays.stream(split).allMatch(digit -> digit.equals(split[0]));
    }

    private Integer calculateDigit(String cpf, Integer factor, Integer max) {
        int total = 0;
        int[] ints = toDigitArray(cpf);
        int[] cutDigits = Arrays.copyOfRange(ints, 0, max);

        for (int digit: cutDigits) {
            total += digit * factor--;
        }
        return (total%11 < 2) ? 0 : (11 - total%11);
    }

    private int[] toDigitArray(String cpf) {
        String[] cpfArray = cpf.split("");
        return Arrays.stream(cpfArray)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String getCheckDigit(String cpf) {
        return cpf.substring(9);
    }
}
