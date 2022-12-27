/*
https://leetcode.com/problems/minimum-window-substring/description/

tally the chars in t with array hash -> use variable sliding window on s -> add each leading edge char -> if s count matches t count, increment matches -> while trailing edge is on chars not in t or excess chars in s, increment trailing edge but NEVER CREATE AN INVALID WINDOW -> if the leading/trailing edge width is less than previous, update start and width for string

time: O(|s|) -> count t O(|t|) -> all possible windows O(|s|) -> move back window O(1) -> minimum string size O(1)
space: O(|s| + SIGMA) -> arrays to count alphabet chars O(SIGMA) -> s stored as char array O(|s|)
*/

class Solution {
    public String minWindow(String s, String t) {
        if (s == "" || t == "" || s.length() < t.length()) {
            return "";
        }

        char[] sChars = s.toCharArray();

        int minStart = 0;
        int minWidth = Integer.MAX_VALUE;

        int[] tC = new int[256];
        int[] sC = new int[256];

        int tMatch = 0;
        int sMatch = 0;
        
        for (char c : t.toCharArray()) {
            tC[c - 'A']++;
            if (tC[c - 'A'] == 1) tMatch++;
        }
        
        int left = 0;
        for (int i = 0; i < sChars.length; i++) {
            int rightC = sChars[i] - 'A';

            if (tC[rightC] > 0) {
                sC[rightC]++;
                if (sC[rightC] == tC[rightC]) {
                    sMatch++;
                }
            }
            
            int leftC = sChars[left] - 'A';
            while (left < i && (tC[leftC] == 0 || sC[leftC] > tC[leftC])) {
                sC[leftC]--;
                leftC = sChars[++left] - 'A';
            }

            if (sMatch == tMatch) {
                if ((i + 1 - left) < (minWidth)) {
                    minStart = left;
                    minWidth = i + 1 - left;
                }
            }
        }

        return (minWidth == Integer.MAX_VALUE) ? "" : new String(Arrays.copyOfRange(sChars, minStart, minStart + minWidth));
    }
}
