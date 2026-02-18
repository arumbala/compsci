package com.arumbala.dsa.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Smallest Positive Integer (MissingInteger)
 *
 * Given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 *
 * Example: A = [1, 3, 6, 4, 1, 2] → return 5
 * Example: A = [1, 2, 3] → return 4
 * Example: A = [-1, -3] → return 1
 *
 * N is an integer within the range [1..100,000]
 * Each element of array A is an integer within the range [-1,000,000..1,000,000]
 */
public class SmallestPositiveNumber {
     private static int getSmallestNumber(int[] nums){
        Set<Integer> numSet = new HashSet<Integer>();
        for(int n : nums){
            numSet.add(n);
        }
        for(int i = 1; i <= nums.length + 1; i++){
            if(!numSet.contains(i)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getSmallestNumber(new int[]{1, 3, 6, 4, 1, 2})); // 5
        System.out.println(getSmallestNumber(new int[]{1, 2, 3})); // 4
        System.out.println(getSmallestNumber(new int[]{-1, -3}));  // 1
    }
}
