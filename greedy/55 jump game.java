/*
https://leetcode.com/problems/jump-game/description/

greedily take the most jumps available -> for each day, take max of current amount and nums[i] -> decrement jumps (use a jump) -> if jumps < 0, cannot reach next day (final day si fine)

time: O(n) -> check each day O(n) -> max of jumps, nums[day] O(1)
space: O(1) -> jumps counter O(1)
*/

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            jumps = Math.max(jumps, nums[i]);
            jumps--;
            if (jumps == - 1) return false;
        }

        return jumps != -1;
    }
}
