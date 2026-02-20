package com.arumbala.lcblind75.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 *
 * Given an array of integers and a target, return indices of
 * the two numbers that add up to the target.
 * Each input has exactly one solution. Cannot use same element twice.
 *
 * Example: nums = [2,7,11,15], target = 9 → return [0,1]
 * Example: nums = [3,2,4], target = 6 → return [1,2]
 *
 * Time: O(n), Space: O(n)
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> existingNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int requiredNumber = target - nums[i];
            if(existingNums.containsKey(requiredNumber)){
                return new int[]{existingNums.get(requiredNumber), i};
            }
            existingNums.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));  // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));        // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));           // [0, 1]
    }
}