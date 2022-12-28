/*
https://leetcode.com/problems/search-a-2d-matrix/description/

treat as array of length mn -> map mid to matrix index as row = mid/|columns|, column = mid % |columns| -> perform regular binary search

time: O(log mn) -> binary search as single array of length mn 
space: O(1) -> pointers for matrix lengths, left/right/midpoint indices
*/

impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
        let m = matrix.len();
        let n = matrix[0].len();

        let mut l = 0;
        let mut r = m * n;

        while l < r {
            let mid = l + ((r - l) / 2);
            let row = mid / n;
            let col = mid % n;

            if matrix[row][col] == target {
                return true
            }
            else if matrix[row][col] < target {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }

        false
    }
}
