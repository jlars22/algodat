package com.jonas.lecture_2.stack;

public class BalanceParenthesis {
    public static boolean balPar(String text) {
        Stack<Character> stack = new StackImplementation<>(text.length());
        char[] array = text.toCharArray();

        for (char element : array) {
            if (element == '(') {
                stack.push(element);
            } else if (element == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            } else {
                throw new IllegalStateException("Non expected character in text");
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balPar("()") + " = true");
        System.out.println(balPar("(())") + " = true");
        System.out.println(balPar("(()") + " = false");
        System.out.println(balPar(")(") + " = false");
        System.out.println(balPar("()()") + " = true");
        System.out.println(balPar("((())())") + " = true");
        System.out.println(balPar("((())") + " = false");
        System.out.println(balPar("") + " = true");
    }
}