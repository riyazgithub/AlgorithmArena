package com.ds.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class DailyTemparature {

    class IntPair {
        private int first;
        private int second;

        public IntPair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] retArr = new int[temperatures.length];
        Stack<IntPair> s = new Stack<>();
        int curr = 0;
        while (curr < temperatures.length) {
            while(!s.isEmpty() && temperatures[curr] > s.peek().getFirst()) {
                IntPair ip = s.pop();
                retArr[ip.getSecond()] = curr - ip.getSecond();
            }
            s.push(new IntPair(temperatures[curr],curr));
            curr++;
        }
        return retArr;
    }

    public int[] dailyTemperaturesEfficient(int[] temperatures) {
        int[] retArr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                retArr[index] = i - index;
            }
            stack.push(i);
        }

        return retArr;
    }

    public static void main(String[] args) {
        int[] t = new int[]{73,74,75,71,69,72,76,73};
        DailyTemparature dt = new DailyTemparature();
        System.out.println(Arrays.toString(dt.dailyTemperatures(t)));
    }
}
