package arrays.leetcodeSolutions.slidingWindow;

//209. Minimum Size Subarray Sum

//Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
//whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

public class MinimumSizeSubaray {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;


        //Time complexity: O(n)
        //Each element is added once (by right pointer) and removed at most once (by left pointer)
        //Space complexity: O(1)

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            //Shrink window while valid
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        //If no valid window found, return 0
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
