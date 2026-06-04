package arrays.leetcodeSolutions.kadane;

//152. Maximum Product Subarray

//Given an integer array nums, find a subarray that has the largest product, and return the product.
//The test cases are generated so that the answer will fit in a 32-bit integer.
//Note that the product of an array with a single element is the value of that element.

public class MaximumProductSubarray {

    //Time complexity: O(n)
    //Space complexity: O(1)
    public int maxProduct(int[] nums) {

        // Maximum product ending at current position
        int currentMax = nums[0];

        // Minimum product ending at current position
        int currentMin = nums[0];

        // Global maximum product
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            //Negative number changes the sign
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            //Either extend the previous product or start a new one from num
            currentMax = Math.max(num, currentMax * num);

            currentMin = Math.min(num, currentMin * num);

            // Update global maximum
            result = Math.max(result, currentMax);
        }
        return result;
    }
}
