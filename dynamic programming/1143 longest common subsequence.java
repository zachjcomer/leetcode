/*
https://leetcode.com/problems/longest-common-subsequence/description/

LCM(i,j) = 1 + LCM(i+1,j+1) if match, else max(L(i+1), j), LCM(i,j+1) -> LCM(i,j) = 0 for i, j = 0

time: O(|text1||text2|) -> compare all prefixes of text1 to the prefixes of text2 -> work is max, addition in eah subprob O(1)
space: O(|text1|) -> only need to store current row and last row
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {    
        if (text1.length() == 0 || text2.length() == 0) return 0;    

        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int[] memo = new int[s.length + 1];
        int[] memoOld = new int[s.length + 1];

        for (int j = 1; j <= t.length; j++) {
            for (int i = 1; i <= s.length; i++) {
                if (s[i - 1] == t[j - 1]) {
                    memo[i] = 1 + memoOld[i - 1];
                }
                else {
                    memo[i] = Math.max(memo[i - 1], memoOld[i]);
                }
            }

            memoOld = Arrays.copyOf(memo, memo.length);
        }

        return memo[s.length];
    }
}
