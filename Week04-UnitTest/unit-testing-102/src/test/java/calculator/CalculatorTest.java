package calculator;

import example.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {


    //(CSV = Comma Separated Values)
    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "5, 7, 12",
            "10, 20, 30",
            "-2, 5, 3",
            "-4,-10, -14",
            "-7, 2, -5",
            "134689, 0, 134689",
            "256856, 36985, 293841",
            "600000, 60000, 660000",
            "1000, 3700, 4700"
    })


    void testAdd(int a, int b, int expected) {
        Calculator calculator = new Calculator();
        int result = calculator.add(a, b);
        Assertions.assertEquals(expected, result);
    }





}
