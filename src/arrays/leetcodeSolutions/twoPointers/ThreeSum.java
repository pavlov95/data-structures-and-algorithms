package arrays.leetcodeSolutions.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 3Sum
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
//such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.

public class ThreeSum {


    // Time complexity: O(n*n)
    // Space complexity: O(1) excluding output
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length<3) {
            return result;
        }
        //Time complexity: O(n * log n)
        //Java’s primitive-array quicksort uses recursion internally,
        //so technically the call stack can reach: O(log n)
        Arrays.sort(nums);
        // Time complexity: O(n)
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;
            //Time complexity: O(n)
            while (leftPointer < rightPointer) {
                int sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                if (sum == 0) {
                    result.add(Arrays.asList(
                            nums[i],
                            nums[leftPointer],
                            nums[rightPointer]
                    ));
                    //Eliminating duplicates here instead of checking result later
                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer++;
                    }
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer--;
                    }
                    leftPointer++;
                    rightPointer--;

                } else if (sum < 0) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }

        return result;
    }
}
