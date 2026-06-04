package arrays.leetcodeSolutions.prefixSumHashing;

import java.util.HashMap;
import java.util.Map;

//560. Subarray Sum Equals K

//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//A subarray is a contiguous non-empty sequence of elements within an array.

public class SubarraySumEqualsK {
    //Time complexity: O(n)
    //Space complexity: O(n)
    public int subarraySum(int[] nums, int k) {
        //Create a map that tracks the frequency of the sums
        Map<Integer, Integer> prefixCount = new HashMap<>();

        //Prefix sum 0 exists once before starting
        prefixCount.put(0, 1);

        int currentSum = 0;
        int result = 0;

        for (int num : nums) {
            currentSum += num;
            //Check if such a sum exists
            result += prefixCount.getOrDefault(currentSum - k, 0);

            // Store current prefix sum frequency
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }
        return result;
    }
}