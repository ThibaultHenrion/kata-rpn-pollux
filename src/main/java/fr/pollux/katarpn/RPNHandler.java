package fr.pollux.katarpn;

import fr.pollux.katarpn.exception.InvalidFormatException;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class RPNHandler {
    private List<String> tokens;
    private Stack<Double> stack;

    public RPNHandler(String rpn) {
        tokens = Arrays.asList(rpn.split(" "));
        stack = new Stack<>();
    }

     public double operations() throws InvalidFormatException {
        try {
            for (String el : tokens) {
                switch (el) {
                    case "+":
                        stack.add(Operation.addition(stack.pop(), stack.pop()));
                        break;
                    case "-":
                        stack.add(Operation.substraction(stack.pop(), stack.pop()));
                        break;
                    case "*":
                        stack.add(Operation.multiplication(stack.pop(), stack.pop()));
                        break;
                    case "/":
                        stack.add(Operation.division(stack.pop(), stack.pop()));
                        break;
                    case "sqrt":
                        stack.add(Operation.squareRoot(stack.pop()));
                        break;
                    case "max":
                        double maxNumber = Operation.maximum(stack);
                        stack.clear();
                        stack.add(maxNumber);
                        break;
                    case "min":
                        double minNumber = Operation.minimum(stack);
                        stack.clear();
                        stack.add(minNumber);
                        break;
                    case "^":
                        stack.add(Operation.power(stack.pop(), stack.pop()));
                        break;
                    default:
                        stack.add(Double.parseDouble(el));
                }
            }
        }
        catch (NumberFormatException|EmptyStackException e){
            throw new InvalidFormatException();
        }

        if(stack.size() == 1) {
            return stack.pop();
        }
        throw new InvalidFormatException();
    }
}
