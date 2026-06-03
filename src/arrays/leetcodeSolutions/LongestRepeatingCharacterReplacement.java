package arrays.leetcodeSolutions;

//424. Longest Repeating Character Replacement

//You are given a string s and an integer k. You can choose any character of the string and change it to any other
//uppercase English character. You can perform this operation at most k times.
//Return the length of the longest substring containing the same letter you can get after performing the above operations.

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {

        //Frequency of uppercase English letters
        int[] count = new int[26];

        int left = 0;

        //Stores count of the most frequent character inside the current window
        int maxFrequency = 0;

        int longest = 0;

        for (int right = 0; right < s.length(); right++) {

            //Add current character to window
            count[s.charAt(right) - 'A']++;

            //Update max frequency character in window
            maxFrequency = Math.max(
                    maxFrequency,
                    count[s.charAt(right) - 'A']
            );

            //If replacements needed exceed k, shrink the window.
            //Replacements needed = window size - most frequent character count

            while ((right - left + 1) - maxFrequency > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            //Update longest valid window
            longest = Math.max(
                    longest,
                    right - left + 1
            );
        }
        return longest;
    }
}
