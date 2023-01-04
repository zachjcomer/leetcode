/*
https://leetcode.com/problems/delete-columns-to-make-sorted/description/

for each string column -> check that the previous char in the col is <= the current -> otherwise column isn't sorted -> increment out

time: O(nm) -> for each string column O(m) -> for each char in column O(n) -> check sort O(1)
space: O(nm) -> pass entire string array to func O(mn)
*/

class Solution {
    public int minDeletionSize(String[] strs) {
        int out = 0;
        for (int j = 0; j < strs[0].length(); j++) {
           if (!isSorted(strs, j)) out++;
        }

        return out;
    }

    boolean isSorted(String[] strs, int col) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(col) < strs[i - 1].charAt(col)) return false;
        }

        return true;
    }
}
