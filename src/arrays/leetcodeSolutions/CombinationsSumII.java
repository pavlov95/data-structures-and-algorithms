package arrays.leetcodeSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSumII {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentSequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, n);
        return result;
    }

    private void backtrack(int[] candidates, int remainder, int index, int n) {
        if (remainder == 0) {
            result.add(new ArrayList<>(currentSequence));
            return;
        }
        if (remainder < 0) {
            return;
        }
        for (int i = index; i < n; i++) {

            //Avoid duplicates
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > remainder) {
                break;
            }
            currentSequence.add(candidates[i]);

            // Index is added 1 to skip the current element;
            backtrack(candidates, remainder - candidates[i], i + 1, n);

            currentSequence.removeLast();
        }
    }
}
