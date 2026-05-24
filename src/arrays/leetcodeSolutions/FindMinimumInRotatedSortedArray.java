package arrays.leetcodeSolutions;

//153. Find Minimum in Rotated Sorted Array

//Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//You must write an algorithm that runs in O(log n) time.

//Space complexity: O(1)
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (left + right) / 2;

            //If mid is greater than right, min is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            //Otherwise, min is in left half (including mid)
            else {
                right = mid;
            }
        }
        return nums[left];
    }
}
