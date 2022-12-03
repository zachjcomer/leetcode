/*
https://leetcode.com/problems/longest-repeating-character-replacement/description/

(F: |substr| -> substr_valid) is monotonic -> can binary search over lengths of substrs -> search substrings of length mid
tally  w/ |window| = window valid if (mid - [max in window] <= k) -> slide window until valid (count left--, right++) -> do for each mid until binary search converges

time: O(n log n) -> O(log n) to binary search window sizes -> O(n) to verify window (count 0 to |window| then slide window until valid substr)
space: O(m) -> size of alphabet for counter
*/

class Solution {
    public int characterReplacement(String s, int k) {
        char[] s_chars = s.toCharArray();

        int left = 1;               // max valid substr length (increases)
        int right = s.length() + 1; // one above search area (decreases)
        int window = 0;             // midpoint targ size
        
        while(left + 1 < right) {
            window = (left + right) / 2;

            int max = 0;
            int[] count = new int[26];

            // initial window count
            for (int i = 0; i < window; i++) {
                count[s_chars[i] - 'A']++;
                max = Math.max(max, count[s_chars[i] - 'A']);
            }

            int j = 0;

            // slide window and increment chars, max
            while (j + window < s.length() && window - max > k) {
                count[s_chars[j] - 'A']--;
                count[s_chars[j + window] - 'A']++;
                max = Math.max(max, count[s_chars[j + window] - 'A']);

                j++;
            }
            
            // not found, search lower area
            if (window - max > k) {
                right = window;
            }
            // window is valid, search upper area
            else {
                left = window;
            }
        }

        return left;
    }
}
