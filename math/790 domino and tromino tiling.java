/*
https://leetcode.com/problems/domino-and-tromino-tiling/

recurrence for all tiling endings -> recurrence relation for tromino complements -> simplify all 3 recurrences -> solve T(n) = 2T(n - 1) + T(n - 3) for all n w/ initial conds

time: O(n) -> find T(n) O(1) -> for all n O(n)
space: O(1) -> values for the last 3 tilings O(1)
*/

class Solution {
    public int numTilings(int n) {
        int TN_3 = -1;
        int TN_2 = 0;
        int TN_1 = 1;

        int TN = 0;

        for (int i = 1; i <= n; i++) {
            TN = (int) ((2L * TN_1 + TN_3) % (1_000_000_007));

            TN_3 = TN_2;
            TN_2 = TN_1;
            TN_1 = TN;
        }

        return TN;
    }
}
