package edu.homework1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivTests extends CalcTests {
    private static final double d = 0.1;

    @ParameterizedTest
    @CsvSource({"0, 1, 0", "10, 2, 5", "1, 3, 0.33", "0.5, 2, 0.25"})
    void tableValuesTest(double number, double power, double result) {
        assertEquals(result, calculator.div(number, power), d);
    }

}