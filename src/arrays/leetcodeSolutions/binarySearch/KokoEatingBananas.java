package arrays.leetcodeSolutions.binarySearch;

// 875. Koko Eating Bananas

//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
//The guards have gone and will come back in h hours. Koko can decide her bananas-per-hour eating speed of k.
//Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
//she eats all of them instead and will not eat any more bananas during this hour.

//Return the minimum integer k such that she can eat all the bananas within h hours.

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        //Search space can be optimized slightly
        int left = 1;
        int right = 0;
        //Find max pile
        //Time complexity: O(n)
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        //Time complexity: O(n log m)
        //n is number of elements in the piles array
        //m is the maximum pile size
        //Space complexity: O(1)
        while (left < right) {
            int mid = (left+right)/2;

            //Total hours needed for speed = mid
            int hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // Same as ceil(pile / mid)
            }

            //Speed is sufficient
            if (hours <= h) {
                right = mid;
            }
            //Speed is too slow
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}

