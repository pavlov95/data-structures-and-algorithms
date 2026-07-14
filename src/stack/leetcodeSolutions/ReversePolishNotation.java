package stack.leetcodeSolutions;

//150. Evaluate Reverse Polish Notation
//Medium
//        Topics
//premium lock icon
//        Companies
//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//Evaluate the expression. Return an integer that represents the value of the expression.
//
//Note that:
//
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.

import java.util.ArrayDeque;

public class ReversePolishNotation {

    //Time complexity: O(n)
    //Space complexity: O(n)
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int right = stack.pop();
                int left = stack.pop();

                int result = switch (token) {
                    case "+" -> left + right;
                    case "-" -> left - right;
                    case "*" -> left * right;
                    case "/" -> left / right;
                    default -> throw new IllegalArgumentException("Unknown operator: " + token);
                };

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/");
    }
}
