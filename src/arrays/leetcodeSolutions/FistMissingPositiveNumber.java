package arrays.leetcodeSolutions;

public class FistMissingPositiveNumber {

    //Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
    //You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //Place numbers in correct positions
        //Each number is moved at most once into its correct position so time complexity is O(n)
        //Space complexity: O(1)
        for (int i = 0; i < n; i++) {

            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;

                //Swap current index into correct position
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        //Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
