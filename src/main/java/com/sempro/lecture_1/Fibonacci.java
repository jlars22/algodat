package com.sempro.lecture_1;

import java.util.Stack;

public class Fibonacci {

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n - 2) + fib(n - 1);
    }



}
