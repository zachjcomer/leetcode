/*
https://leetcode.com/problems/minimum-falling-path-sum/description/

path sum = matrix val + min(3 subprobs below) -> compute from bottom to top iteratively -> take min of top row

time: O(n^2) -> for every row O(n) -> compute each path [mat val + min(3)] O(n) -> min of top row O(n)
space: O(n^2) -> memoization for all path starting points
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        
        for (int j = 0; j < matrix[0].length; j++) {
            memo[matrix.length - 1][j] = matrix[matrix.length - 1][j];
        }

        for (int i = matrix.length - 2; i >= 0; i--) {
            memo[i][0] = matrix[i][0] + Math.min(memo[i + 1][0], memo[i + 1][1]);
            memo[i][matrix[i].length - 1] = matrix[i][matrix[i].length - 1] + Math.min(memo[i + 1][matrix[i].length - 1], memo[i + 1][matrix[i].length - 2]);

            for (int j = matrix[0].length - 2; j >= 1; j--) {
                memo[i][j] = matrix[i][j];
                memo[i][j] += Math.min(
                    Math.min(memo[i + 1][j - 1], memo[i + 1][j + 1]),
                    memo[i + 1][j]
                );
            }
        }

        int min_path = Integer.MAX_VALUE;
        for (int path : memo[0]) {
            min_path = Math.min(min_path, path);
        }

        return min_path;
    }
}
