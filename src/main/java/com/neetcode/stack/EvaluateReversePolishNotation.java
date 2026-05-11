package com.neetcode.stack;

import com.neetcode.arraynhashing.TopKFrequentElements;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                int num = Integer.parseInt(token);
                numStack.push(num);
                continue;
            }
            if (numStack.isEmpty()) {
                return 0;
            }
            int opt2 = numStack.pop();
            int opt1= numStack.pop();
            int result = calculate(opt1, opt2, token);
            numStack.push(result);
        }
        return numStack.pop();
    }

    private Integer calculate(int opt1, int opt2, String operator) {
        return switch (operator) {
            case "+" -> opt1 + opt2;
            case "-" -> opt1 - opt2;
            case "*" -> opt1 * opt2;
            case "/" -> opt1 / opt2;
            default -> 0;
        };
    }
}


class EvaluateReversePolishNotationPractice {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!"+".equals(token) && !"-".equals(token) && !"*".equals(token) && !"/".equals(token)) {
                int num = Integer.parseInt(token);
                stack.push(num);
                continue;
            }
            if (stack.isEmpty()) return -5555555; // wrong
            int num2 = stack.pop();
            int num1 = stack.pop();
            int res = calculate(num1, num2, token);
            stack.push(res);
        }
        return stack.peek();
    }

    private int calculate(int opt1, int opt2, String operand) {
        switch (operand) {
            case "+":
                return opt1 + opt2;
            case "-":
                return opt1 - opt2;
            case "*":
                return opt1 * opt2;
            case "/":
                return opt1 / opt2;
        }
        return opt1 + opt2;
    }


}