package arrays.leetcodeSolutions.twoPointers;

//You are given an integer array height of length n. There are n vertical lines drawn such that the
//two endpoints of the ith line are (i, 0) and (i, height[i]).
//Find two lines that together with the x-axis form a container, such that the container
//contains the most water.
//Return the maximum amount of water a container can store.
//Notice that you may not slant the container.

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null){
            return 0;
        }
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxWater = 0;
        //Time complexity: O(n)
        //Space complexity: O(1)
        while (leftPointer < rightPointer) {
            int containerHeight = Math.min(height[leftPointer], height[rightPointer]);
            int containerWidth = rightPointer - leftPointer;
            maxWater = Math.max(maxWater, containerHeight * containerWidth);

            // Move the smaller height
            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxWater;
    }
}
