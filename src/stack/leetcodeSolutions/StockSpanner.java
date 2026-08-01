package stack.leetcodeSolutions;

import java.util.ArrayDeque;

//Time complexity: O(1) amortized per next() call ; O(n) worst case for one call
//Space complexity: O(n)
public class StockSpanner {

    private final ArrayDeque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        //Every price has at least span 1 because it includes today
        int span = 1;


        //If previous prices are less than or equal to today's price, they are included in today's span.
        //We can also add their stored spans directly because each popped price already represents several
        //previous days.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        //Store today's price together with its calculated span
        stack.push(new int[]{price, span});

        return span;
    }

}
