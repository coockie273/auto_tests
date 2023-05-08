package edu.homework1;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

public class CalcTests {
    protected static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }
}