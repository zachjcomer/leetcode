/*
https://leetcode.com/problems/longest-repeating-character-replacement/description/

char w/ max count in window is mode -> increase window right edge -> increase left edge until k non-mode entries in window -> max len each time

time: O(n) -> right edge moves 1 each time -> left edge moves 0 to window - k times
space: O(n + m) -> O(n) for string as char array -> O(m) for counting alphabet of size m
*/

class Solution {
    public int characterReplacement(String s, int k) {
        char[] s_chars = s.toCharArray(); // O(n) space
        
        int[] count = new int[26]; // O(m) space
        int max = 0;

        int mode = 0;
        int start = 0;
        
        // single pass O(n)
        for (int i = 0; i < s.length(); i++) {
            count[s_chars[i] - 'A']++;
            mode = Math.max(mode, count[s_chars[i] - 'A']); // can only come from itself or newly tallied char

            // non-char comes from all chars not part of the mode
            while (i + 1 - start - mode > k) {
                count[s_chars[start] - 'A']--;
                start++;
            }

            max = Math.max(max, i + 1 - start);
        }

        return max;
    }
}
