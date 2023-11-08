package fr.pollux.katarpn;

import fr.pollux.katarpn.exception.InvalidFormatException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationTestU {

    @Test
    public void operationAdditionWorks() {
        double num1 = 1, num2 = 2;

        double result = Operation.addition(num1, num2);

        assertEquals(3, result, 0);
    }

    @Test
    public void operationSubstractionWorks() {
        int num1 = 2, num2 = 1;

        double result = Operation.substraction(num1, num2);

        assertEquals(-1, result, 0);
    }

}
