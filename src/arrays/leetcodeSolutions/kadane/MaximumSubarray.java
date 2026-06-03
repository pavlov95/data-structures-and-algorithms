package arrays.leetcodeSolutions;

// 53. Maximum Subarray

//Given an integer array nums, find the subarray with the largest sum, and return its sum.

public class MaximumSubarray {

    //Time complexity: O(n)
    //Space complexity: O(1)
    public int maxSubArray(int[] nums) {

        // Current running subarray sum
        int currentSum = nums[0];

        // Best sum found so far
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            //Either continue with the current subarray or start a new subarray from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            //Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
