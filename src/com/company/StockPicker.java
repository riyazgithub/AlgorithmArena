package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * Closing prices - 100,95,93, 96,93,100,105,98,105,100,95,93, 96,93,100,105,98,105, 95,93, 96,93,91,
 * aisera
 * Stock price -- find best day to buy and sell so that we make maximum profit
 * print the day to purchase and sell including price and profit
 *
 */
public class StockPicker {
    public static void main(String[] args) {
//        int[] stock_prices = new int[]{100,95,93, 96,93,100,105,98,105,100,95,93, 96,93,100,105,98,105, 95,93, 96,93,91};
        int[] stock_prices = new int[]{100,95,93, 96,93,100,105,93,105};
        int[] max_profitArr = new int[stock_prices.length];
        TreeMap<Integer, List<int[]>> sortedProfit = new TreeMap<>(Comparator.reverseOrder());
        int buyDay = 0;
        int sellDay = -1;
        int max_profit = max_profitArr[0];
        int lowPrice = stock_prices[0];


        for (int index = 1; index < stock_prices.length - 1; index++) {
            if (max_profitArr[index-1] <= stock_prices[index] - lowPrice) {
                max_profitArr[index] = stock_prices[index] - lowPrice;
                sellDay = index;
                if (!sortedProfit.containsKey(max_profitArr[index]))
                    sortedProfit.put(max_profitArr[index], new ArrayList<>());
                sortedProfit.get(max_profitArr[index]).add(new int[]{buyDay, sellDay});
            } else {
                max_profitArr[index] = max_profitArr[index-1];
                lowPrice = stock_prices[index];
            }
        }

        if (sellDay != -1) {
            ArrayList<int[]> profitList = (ArrayList<int[]>) sortedProfit.get(max_profitArr[max_profitArr.length-2]);
            for (int[] profit : profitList) {
                System.out.println(String.format("Buy Day %s, Sell Day %s, Profit %s", profit[0], profit[1], max_profitArr[max_profitArr.length-2]));
            }
        }
    }


    }

//        for(int startDay = 0; startDay < stock_prices.length-1; startDay++) {
//            for(int lastDay = startDay+1; lastDay < stock_prices.length; lastDay++)  {
//                int tmpProfit = stock_prices[lastDay] - stock_prices[startDay];
//                if(tmpProfit >= max_profit) {
//                    max_profit = tmpProfit;
//                    buyDay = startDay;
//                    sellDay = lastDay;
//                    if(!sortedProfit.containsKey(max_profit))
//                        sortedProfit.put(max_profit, new ArrayList<>());
//                    sortedProfit.get(max_profit).add(new int[]{buyDay,sellDay});
//                }
//            }
//        }
//
//        if(buyDay != -1 ) {
//            ArrayList<int[]> profitList = (ArrayList<int[]>) sortedProfit.get(max_profit);
//            for (int[] profit : profitList) {
//                System.out.println(String.format("Buy Day %s, Sell Day %s, Profit %s", profit[0], profit[1],max_profit));
//            }
//        }
//    }
//}
