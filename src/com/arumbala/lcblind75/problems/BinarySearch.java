package com.arumbala.lcblind75.problems;

/**
 * Binary Search
 *
 * Given a sorted array of integers and a target, return the index of
 * the target. If not found, return -1.
 *
 * Example: nums = [-1,0,3,5,9,12], target = 9 → return 4
 * Example: nums = [-1,0,3,5,9,12], target = 2 → return -1
 *
 * Time: O(log n), Space: O(1)
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));  // 4
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));  // -1
        System.out.println(search(new int[]{5}, 5));                   // 0
    }
}