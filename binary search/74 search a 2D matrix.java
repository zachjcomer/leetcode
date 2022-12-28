/*
https://leetcode.com/problems/search-a-2d-matrix/description/

treat as array of length mn -> map mid to matrix index as row = mid/|columns|, column = mid % |columns| -> perform regular binary search

time: O(log mn) -> binary search as single array of length mn 
space: O(1) -> pointers for matrix lengths, left/right/midpoint indices
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (matrix[mid / n][mid % n] == target) {
                return true;
            }
            else if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        
        return false;
    }
}
