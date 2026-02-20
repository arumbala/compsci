package com.arumbala.lcblind75.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode #15 - Three Sum (Blind 75)
 *
 * Given an integer array, return all triplets [nums[i], nums[j], nums[k]]
 * such that i != j != k and nums[i] + nums[j] + nums[k] == 0.
 * No duplicate triplets in the result.
 *
 * Example: nums = [-1,0,1,2,-1,-4] → [[-1,-1,2],[-1,0,1]]
 * Example: nums = [0,1,1] → []
 * Example: nums = [0,0,0] → [[0,0,0]]
 *
 * Time: O(n^2), Space: O(1) excluding output
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // Hint: sort array, fix one number, use two pointers for the rest
        if(nums == null || nums.length < 3){
            return Collections.emptyList();
        }
        Arrays.sort(nums);//Must do

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left =  i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{0, 1, 1}));              // []
        System.out.println(threeSum(new int[]{0, 0, 0}));              // [[0,0,0]]
    }
}