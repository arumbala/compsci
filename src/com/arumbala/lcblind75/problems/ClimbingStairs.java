package com.arumbala.lcblind75.problems;

/**
 * Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can climb 1 or 2 steps.
 * Return the number of distinct ways to climb to the top.
 *
 * Example: n = 2 → return 2 (1+1, 2)
 * Example: n = 3 → return 3 (1+1+1, 1+2, 2+1)
 * Example: n = 5 → return 8
 *
 * Time: O(n), Space: O(1)
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if(n <= 1){
            return n;
        }

        int prev1 = 1, prev2 = 2;
        for(int i = 2; i < n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));  // 2
        System.out.println(climbStairs(3));  // 3
        System.out.println(climbStairs(5));  // 8
    }
}