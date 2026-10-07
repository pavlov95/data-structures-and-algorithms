package queue.leetcodeSoludtions;

import java.util.ArrayDeque;
import java.util.Queue;

//You have a RecentCounter class which counts the number of recent requests within a certain time frame.
//
//Implement the RecentCounter class:
//
//RecentCounter() Initializes the counter with zero recent requests.
//int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of
//requests that have happened in the inclusive range [t - 3000, t], that is, the new request plus every earlier request
//that is no more than 3000 milliseconds older.
//It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

public class NumberOfRecentCalls {

    private final Queue<Integer> requests;

    public NumberOfRecentCalls() {
        requests = new ArrayDeque<>();
    }

    public int ping(int t) {
        requests.offer(t);

        while (requests.peek() < t - 3000) {
            requests.poll();
        }

        return requests.size();
    }
}