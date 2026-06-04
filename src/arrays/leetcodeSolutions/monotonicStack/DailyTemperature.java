package arrays.leetcodeSolutions.monotonicStack;

//739. Daily Temperatures

//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
//is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
//which this is possible, keep answer[i] == 0 instead.

import java.util.ArrayDeque;

//Time complexity: O(n) because each element gets pushed and popped exactly once
//Space complexity: O(n)
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        //Use for storing indices
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            //Current temperature is warmer
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
