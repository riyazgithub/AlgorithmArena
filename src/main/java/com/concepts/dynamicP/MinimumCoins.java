package com.concepts.dynamicP;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 */
public class MinimumCoins {

    static Integer minimum_coins(ArrayList<Integer> coins, Integer value) {

        return 0;
    }

    public int coinChange(int[] coins, int amount) {
        if (amount ==0)
            return 0;
        int[] combination = new int[amount+1];
        Arrays.fill(combination, amount+1);
        combination[0] = 0;
        for (int i =1; i<=amount; i++) {
            for(int j =0; j< coins.length; j++) {
                int p = i - coins[j];
                if(p>=0)
                {
                    combination[i] = Math.min(combination[p] + 1,combination[i]);
                }
            }
        }
        return combination[amount]== amount+1 ? -1 : combination[amount] ;
    }

    public static void main(String[] args) {
        int[] coinInt = new int[]{1,2,5};
        int amount = 10;
        MinimumCoins mc = new MinimumCoins();
        System.out.println("Result "+ mc.coinChange(coinInt, amount));

    }

}
