package arrays.leetcodeSolutions;

//56. Merge Intervals

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
//array of the non-overlapping intervals that cover all the intervals in the input.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    //Time complexity: O(n log n)
    //Space complexity: O(n)
    public int[][] merge(int[][] intervals) {
        //Sort the arrays by their beginning index
        //Time complexity: O(n log n)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        //Iterate over the arrays
        //Time complexity: O(n)
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            //If currentStart is <=end that means that the two arrays have to be merged
            //We set the new merged array with the new "end" because the arrays are sorter by their starting index
            if (currentStart <= end) {
                end = Math.max(end, currentEnd);
            //Add the new merged array and continue the cycle with the current array
            } else {
                result.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
