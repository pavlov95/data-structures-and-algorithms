package arrays.leetcodeSolutions;

//496. Next Greater Element I

//The next greater element of some element x in an array is the first greater element that is to the right of x in
//the same array.

//You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater
//element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
//Return an array ans of length nums1.length such that ans[i] is the next greater element as described above

import java.util.ArrayDeque;
import java.util.HashMap;

public class NextGreaterElementI {

    //Time Complexity: O(n+m)
    //Space Complexity: O(m)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        //The HashMap is used to find the next greater element in array nums[2]
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //Find each element's next greater element in array nums2
        //Time complexity for iterating over nums2 : O(m)
        for (int num : nums2) {
            //When the array has a greater element than the current one we add it to the HashMap
            while (!stack.isEmpty() && num > stack.peek()) {
                int smaller = stack.pop();
                map.put(smaller, num);
            }
            stack.push(num);
        }
        //The remaining elements in the stack have no greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        //Build result
        int[] result = new int[nums1.length];

        //Time complexity for iterating over nums1: O(n);
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
