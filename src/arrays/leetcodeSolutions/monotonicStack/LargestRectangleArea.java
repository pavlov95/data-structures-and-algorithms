package arrays.leetcodeSolutions.monotonicStack;

//84. Largest Rectangle in Histogram

//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return
//the area of the largest rectangle in the histogram.

import java.util.ArrayDeque;


public class LargestRectangleArea {
    //Time complexity: O(n)
    //Space complexity: O(n)
    public int largestRectangleArea(int[] heights) {

        //Monotonic increasing stack storing indices of histogram bars.
        //Heights of bars represented by these indices are kept in ascending order.
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        //Iterate through all bars plus one extra iteration.
        //The extra iteration uses a height of 0 to force processing of any bars still remaining in the stack.
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            //If the current bar is lower than the bar at the top of the stack,
            //We've found the right boundary for rectangles using those taller bars.
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                //After popping:
                //The current index i is the first smaller bar on the right.
                //The new stack top is the first smaller bar on the left.
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                //Width spans from the bar after the left boundary
                //To the bar before the current index.
                int width = i - leftBoundary - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
