/*
https://leetcode.com/problems/minimum-average-difference/description/

compute entire array sum -> shift nums[i] from sum to left_sum and find avg dif for each i -> if < min, record new min and index

time: O(n) -> sum array O(n) -> compute left/right averages O(n)
space: O(1) -> track min, index @ min, sums
*/

class Solution {
    public int minimumAverageDifference(int[] nums) {
        long left_sum = 0;
        long right_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            right_sum += nums[i];
        }

        long min = Long.MAX_VALUE;
        int index = 0;

        long val = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            right_sum -= nums[i];
            left_sum += nums[i];

            val = left_sum / (i + 1);
            val -= right_sum / (nums.length - 1 - i);
            val = Math.abs(val);

            if (val < min) {
                min = val;
                index = i;
            }
        }

        val = (left_sum + nums[nums.length - 1]) / nums.length;

        return (val < min) ? nums.length - 1 : index;
    }
}
