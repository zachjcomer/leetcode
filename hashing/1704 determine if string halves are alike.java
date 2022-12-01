/*
https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
string.toLowerCase() https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

convert to lowercase to simplify -> use array map to count characters -> total the net vowel usage per side -> check that its zero

time: O(n) -> iterate over half the array O(n) and count vowels O(1), then iterate over vowels O(1) to tally them
space: O(|s|) -> char array for speed
*/

class Solution {
    public boolean halvesAreAlike(String s) {
        int[] count = new int[26];
        int total = 0;
        char[] c = s.toLowerCase().toCharArray();

        for (int i = 0; i < c.length / 2; i++) {
            count[c[i] - 'a']++;
            count[c[c.length - 1 - i] - 'a']--;
        }

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char ch : vowels) {
            total += count[ch - 'a'];
        }
        return total == 0;
    }
}
