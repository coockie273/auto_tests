package edu.homework1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowTests extends CalcTests {
    private static final double d = 0.1;

    @ParameterizedTest
    @CsvSource({"0, 0, 1", "10, 0, 1", "2, 3, 8", "0.5, 3, 0.125"})
    void tableValuesTest(double number, double power, double result) {
        assertEquals(result, calculator.pow(number, power), d);
    }

}