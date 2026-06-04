package arrays.leetcodeSolutions.twoPointers;

//42. Trapping Rain Water
//Given n non-negative integers representing an elevation map where the width of each bar is 1,
//compute how much water it can trap after raining.
public class TrappingRainWater {

    //Time complexity: O(n)
    //Space complexity: O(1)
    public int trap(int[] height) {
        int leftPonter = 0;
        int rightPoiner = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (leftPonter < rightPoiner) {
            if (height[leftPonter] < height[rightPoiner]) {
                if (height[leftPonter] >= leftMax) {
                    leftMax = height[leftPonter];
                } else {
                    water += leftMax - height[leftPonter];
                }
                leftPonter++;
            } else {
                if (height[rightPoiner] >= rightMax) {
                    rightMax = height[rightPoiner];
                } else {
                    water += rightMax - height[rightPoiner];
                }
                rightPoiner--;
            }
        }
        return water;
    }
}
