package queue.leetcodeSoludtions;

//In the world of Dota2, there are two parties: the Radiant and the Dire.
//
//The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the
//Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of
//the two rights:

//Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
//Announce the victory: If this senator found the senators who still have rights to vote are all from the same party,
//he can announce the victory and decide on the change in the game.
//Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant
//party and the Dire party. Then if there are n senators, the size of the given string will be n.

//The round-based procedure starts from the first senator to the last senator in the given order. This procedure
//will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

//Suppose every senator is smart enough and will play the best strategy for his own party.Predict which party will
//finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".

import java.util.ArrayDeque;

//Time complexity: O(n)
//Space complexity: O(n)
public class Dota2Senate {
    public String predictPartyVictory(String senate) {

        int n = senate.length();

        //Store the indices of active senators from each party.
        ArrayDeque<Integer> radiant = new ArrayDeque<>();
        ArrayDeque<Integer> dire = new ArrayDeque<>();

        //Add each senator's index to the corresponding queue.
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        //Continue until one party has no active senators.
        while (!radiant.isEmpty() && !dire.isEmpty()) {

            // Get the next senator from each party.
            int r = radiant.poll();
            int d = dire.poll();

            //The senator with the smaller index acts firstand bans the senator from the opposing party.
            if (r < d) {

                //Radiant survives and participates in the next round.
                radiant.offer(r + n);

            } else {

                //Dire survives and participates in the next round.
                dire.offer(d + n);
            }
        }

        //The party with remaining senators wins.
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
