package arrays.leetcodeSolutions.slidingWindow;

//713. Subarray Product Less Than K

//Given an array of integers nums and an integer k, return the number of contiguous subarrays where
//the product of all the elements in the subarray is strictly less than k.


public class SubarrayProductLessThanK {

    //Time complexity: O(n)
    //Space complexity: O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(k<=1){
            return 0;
        }
        int result = 0;

        int product = 1;
        //Left boundary of window
        int left = 0;

        //Expand the window using right pointer
        for (int right = 0; right < nums.length; right++) {
            product = product * nums[right];

            //Shrink window from left to right
            while (product >= k) {
                product = product / nums[left];
                left++;
            }

            //Every subarray ending at 'right' and starting from any index between
            //left and right is valid.
            result = result + right - left + 1;
        }

        return result;
    }
}
