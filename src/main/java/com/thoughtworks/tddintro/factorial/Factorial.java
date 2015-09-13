package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        int factorial = 1;
        for (int x = 1; x < i+1; x++) {
            factorial *= x;
        }
        return factorial;
    }
}
