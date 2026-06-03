package arrays.leetcodeSolutions;

import java.util.HashMap;

// 523. Continuous Subarray Sum
//Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

//A good subarray is a subarray where:

//its length is at least two, and
//the sum of the elements of the subarray is a multiple of k.
//Note that:
//
//A subarray is a contiguous part of the array.
//An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

//Time complexity: O(n)
//Space complexity: O(min (k,n))
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {


        HashMap<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            //If this remainder appeared before then the subarray between the two indices
            //has a sum divisible by k.
            if (remainderIndex.containsKey(remainder)) {
                int previousIndex = remainderIndex.get(remainder);
                // Subarray length must be at least 2
                if (i - previousIndex >= 2) {
                    return true;
                }
            } else {
                remainderIndex.put(remainder, i);
            }
        }
        return false;
    }
}