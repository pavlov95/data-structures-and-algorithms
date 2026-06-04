package arrays.leetcodeSolutions.binarySearch;

//1011. Capacity To Ship Packages Within D Days

//A conveyor belt has packages that must be shipped from one port to another within [days] days.
//The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the
//conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
//Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being
//shipped within [days] days.


//Key idea:
//The answer is monotonic:
//If a capacity works, any larger capacity also works.
//So we binary search the capacity range.
//Time complexity:  O(n log S) where S = sum of all weights
//Space complexity: O(1)

public class CapacityToShipPackagesWithinDays {

    public int shipWithinDays(int[] weights, int days) {

        //Lower bound = max single weight (must fit the largest package)
        //Upper bound = sum of all weights (ship everything in one day)
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        //Binary search on answer (capacity)
        while (left < right) {

            int mid = left + (right - left) / 2;

            //Simulate how many days needed with capacity = mid
            int requiredDays = 1;
            int currentLoad = 0;

            for (int weight : weights) {

                //If adding this package exceeds capacity, we start a new day
                if (currentLoad + weight > mid) {
                    requiredDays++;
                    currentLoad = 0;
                }

                currentLoad += weight;
            }

            //If we need too many days, capacity is too small
            if (requiredDays > days) {
                left = mid + 1;
            }
            //Otherwise capacity works, try smaller
            else {
                right = mid;
            }
        }
        return left;
    }
}