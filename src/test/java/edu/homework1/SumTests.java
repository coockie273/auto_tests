package edu.homework1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTests extends CalcTests {
    private static final double d = 0.1;

    @ParameterizedTest
    @CsvSource({"0, 0, 0", "0, 5, 5", "0.33, 0.13, 0.46", "3, -2, 1"})
    void tableValuesTest(double summand1, double summand2, double result) {
        assertEquals(result, calculator.sum(summand1, summand2), d);
    }

}