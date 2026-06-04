package arrays.leetcodeSolutions.backtracking;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150
combinations for the given input.
*/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentSequence = new ArrayList<>();

    //Time complexity: O(2^target)
    //Space complexity: O(n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        backtrack(n, candidates, target, 0);
        return result;
    }

    public void backtrack(int n, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(currentSequence));
            return;
        }

        if (target < 0) {
            return;
        }

        //Try every candidate starting from current index.
        //Starting from "index" avoids duplicate combinations.
        for (int i = index; i < n; i++) {
            if (candidates[i] <= target) {
                currentSequence.add(candidates[i]);
                backtrack(n, candidates, target - candidates[i], i);
                currentSequence.removeLast();
            }
        }

    }
}

