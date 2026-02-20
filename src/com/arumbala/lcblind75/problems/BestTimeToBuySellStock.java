package com.arumbala.lcblind75.problems;

/**
 * Best Time to Buy and Sell Stock
 *
 * Given an array prices where prices[i] is the price on the ith day,
 * find the maximum profit from one buy and one sell.
 * You must buy before you sell.
 *
 * Example: prices = [7,1,5,3,6,4] → return 5 (buy at 1, sell at 6)
 * Example: prices = [7,6,4,3,1] → return 0 (no profit possible)
 *
 * Time: O(n), Space: O(1)
 */
public class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int currentProfit = prices[i] - minPrice;
            if(currentProfit > maxProfit){
                maxProfit =  currentProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
        System.out.println(maxProfit(new int[]{2, 4, 1}));           // 2
    }
}