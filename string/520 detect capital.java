/*
https://leetcode.com/problems/detect-capital/description/

count caps/lower -> if magnitude of count = |word|, valid -> for proper case, must be 2 less than |word| and first letter must be caps -> else, not valid case

time: O(|word|) -> tally each character O(|word|) -> check count result O(1)
space: O(1) -> tally for caps/lower
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c - 'A' < 32) {
                count++;
            } else {
                count--;
            }
        }

        if (Math.abs(count) == word.length()) return true;
        if (count == -1 * word.length() + 2 && word.charAt(0) - 'A' < 32) return true;
        return false;
    }
}
