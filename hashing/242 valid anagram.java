/*
https://leetcode.com/problems/valid-anagram/description/

counter using array -> index = char - 'a'
count up string s -> count down string t -> if any nonzero, not an anagram
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] tally = new int[26];

        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();

        for (char c : sC) {
            tally[c - 'a']++;
        }

        for (char c : tC) {
            tally[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (tally[i] != 0) return false;
        }

        return true;
    }
}
