/*
https://leetcode.com/problems/matrix-diagonal-sum/description/

main diag and opposite are related by row length -> iterate over all rows -> add diag vals -> remove duplicate if needed

time: O(n) -> all rows O(n) -> diags in row O(1) -> del dupe O(1)
space: O(1) -> sum value O(1)
*/

impl Solution {
    pub fn diagonal_sum(mat: Vec<Vec<i32>>) -> i32 {
        let n = mat.len();
        let mut sum = 0;

        for i in 0..n {
            sum = sum + mat[i][i] + mat[n - i - 1][i];
        }

        if n % 2 == 1 {
            sum = sum - mat[n / 2][n / 2];
        }

        sum
    }
}
