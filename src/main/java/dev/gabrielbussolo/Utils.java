package dev.gabrielbussolo;

import java.util.Arrays;
import java.util.stream.Stream;

public class Utils {

    private static final Integer FACTOR_DIGIT_1 = 10;
    private static final Integer FACTOR_DIGIT_2 = 11;
    private static final Integer MAX_DIGITS_1 = 9;
    private static final Integer MAX_DIGITS_2 = 10;

    public static boolean validCpf(String cpf){
        cpf = extractDigits(cpf);
        if (isInvalidLength(cpf)) return false;
        if (isBlocked(cpf)) return false;
        Integer digit1 = calculateDigit(cpf, FACTOR_DIGIT_1, MAX_DIGITS_1);
        Integer digit2 = calculateDigit(cpf, FACTOR_DIGIT_2, MAX_DIGITS_2);
        String calculatedCheckDigit = ""+digit1+digit2;
        return getCheckDigit(cpf).equals(calculatedCheckDigit);
    }

    private static String extractDigits(String cpf) {
        return cpf.replaceAll("\\D", "");
    }

    private static boolean isInvalidLength(String cpf) {
        return cpf.length() != 11;
    }

    private static boolean isBlocked(String cpf) {
        String[] split = cpf.split("");
        return Arrays.stream(split).allMatch(digit -> digit.equals(split[0]));
    }

    private static Integer calculateDigit(String cpf, Integer factor, Integer max) {
        int total = 0;
        int[] ints = toDigitArray(cpf);
        int[] cutDigits = Arrays.copyOfRange(ints, 0, max);

        for (int digit: cutDigits) {
            total += digit * factor--;
        }
        return (total%11 < 2) ? 0 : (11 - total%11);
    }

    private static int[] toDigitArray(String cpf) {
        String[] cpfArray = cpf.split("");
        return Arrays.stream(cpfArray)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String getCheckDigit(String cpf) {
        return cpf.substring(9);
    }
}
