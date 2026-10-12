package queue.leetcodeSoludtions;

import java.util.ArrayDeque;
import java.util.Arrays;

public class RevealCardsInIncreasingOrder {

    //Time complexity: O(n log n)
    //Space complexity: O(n)
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        //Sort the cards in increasing order.
        Arrays.sort(deck);

        //Create a queue containing all deck indices.
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        //Create an array for the final deck arrangement.
        int[] result = new int[n];

        //Simulate the revealing process using indices.
        for (int card : deck) {

            //Place the next smallest card at the index that would be revealed next.
            int index = queue.poll();
            result[index] = card;

            //Move the next available index to the back of the queue, simulating the card movement.
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        //Return the initial deck arrangement.
        return result;
    }
}


