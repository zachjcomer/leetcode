/*
https://leetcode.com/problems/spiral-matrix-ii/description/

turn whenever appropriate bound is hit -> increment the row/col bound -> countinue on current direction w/ labeling -> do n^2 times

time: O(n^2) -> check every cell's bounds then label
space: O(n^2) -> output array
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] out = new int[n][n];
        int count = n * n;
        int cur = 1;

        int[] vec = new int[] {0, 1};
        int i = 0;
        int j = -1;

        int t = 0;
        int b = n;
        int l = 0;
        int r = n;

        while (cur <= count) {
            if (i + vec[0] < t) {
                vec = new int[] {0, 1};
                l++;
            }
            else if (j + vec[1] >= r) {
                vec = new int[] {1, 0};
                t++;
            }
            else if (i + vec[0] >= b) {
                vec = new int[] {0, -1};
                r--;
            }
            else if (j + vec[1] < l) {
                vec = new int[] {-1, 0};
                b--;
            }
            else {
                out[i + vec[0]][j + vec[1]] = cur;
                cur++;
                i += vec[0];
                j += vec[1];
            }
        }

        return out;
    }
}
