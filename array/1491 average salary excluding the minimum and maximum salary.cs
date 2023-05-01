/*
https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/

traverse in one pass -> add iterand to sum, compare min and max -> subtract min, max from sum and compute

time: O(n) -> array traversal O(n) -> operations per iteration O(1)
space: O(1) -> sum, min, max O(1)
*/

public class Solution {
    public double Average(int[] salary) {
        return ((double) (salary.Sum() - salary.Min() - salary.Max())) / (salary.Length - 2);
    }
}
