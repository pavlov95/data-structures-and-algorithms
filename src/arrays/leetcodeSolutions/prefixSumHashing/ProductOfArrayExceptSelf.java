package arrays.leetcodeSolutions.prefixSumHashing;

//238. Product of Array Except Self

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all
//the elements of nums except nums[i].
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//You must write an algorithm that runs in O(n) time and without using the division operation.

import java.util.HashMap;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums.length];
        result[0]=1;
        for (int i = 1; i < nums.length; i++) {

            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            //Multiply left product by right product
            result[i] = result[i] * suffix;

            //Update suffix product
            suffix *= nums[i];
        }
        return result;
    }
}
