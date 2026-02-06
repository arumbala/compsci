package com.arumbala.lc.problems;

// LeetCode #371 - Sum of Two Integers
// Adds two integers without using + or - operators.
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int sumWithoutCarry = a ^ b;
            int carry = (a & b) << 1;
            a = sumWithoutCarry;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers sol = new SumOfTwoIntegers();
        System.out.println("getSum(1, 2) = " + sol.getSum(1, 2));
        System.out.println("getSum(3, 5) = " + sol.getSum(3, 5));
        System.out.println("getSum(-1, 1) = " + sol.getSum(-1, 1));
    }
}