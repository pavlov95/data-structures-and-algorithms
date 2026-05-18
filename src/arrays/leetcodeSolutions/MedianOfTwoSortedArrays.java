package arrays.leetcodeSolutions;

//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two
//sorted arrays.
//The overall run time complexity should be O(log (m+n)).

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] smallerArray = nums1;
        int[] largerArray = nums2;

        // find smallerArray array
        if (nums2.length < nums1.length) {
            smallerArray = nums2;
            largerArray = nums1;
        }

        int m = smallerArray.length;
        int n = largerArray.length;

        int left = 0;
        int right = m;

        while (left <= right) {
            int partitionX = (left + right) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : smallerArray[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : smallerArray[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : largerArray[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : largerArray[partitionY];

            // correct partition
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // odd total length
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                }
                // even total length
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
            }

            // move left
            if (maxLeftX > minRightY) {
                right = partitionX - 1;
            }
            // move right
            else {
                left = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
