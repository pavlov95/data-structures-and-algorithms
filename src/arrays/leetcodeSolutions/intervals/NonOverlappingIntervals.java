package arrays.leetcodeSolutions;

//435. Non-overlapping Intervals

//Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
//you need to remove to make the rest of the intervals non-overlapping.

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        //Time complexity: O(n log n)
        //Space complexity; O(1)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int kept = 1;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end   = intervals[i][1];

            if (start >= prevEnd) {
                //No overlapping — keep it
                kept++;
                prevEnd = end;
            }
        }
        return intervals.length - kept;
    }
}
