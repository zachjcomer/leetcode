/*
https://leetcode.com/problems/house-robber/description/

R(i) = max val at house i -> R(i) = max(rob i + R(i-2), R(i-1)), ie (rob i and do optimal choice up to i-2) or (dont rob i and keep optimal choice for i-1) -> base: R(i < 0) = 0

time: O(n) -> n subprobs (each house) -> constant work per house
space: O(1) -> track values from house i-2 and i-1
*/

class Solution {
    public int rob(int[] nums) {

        int houseBack = 0;
        int houseMid = 0;

        int[] memo = new int[nums.length + 3];
        for (int i = 0; i < nums.length; i++) {
            int temp = houseBack;
            houseBack = houseMid;
            houseMid = Math.max(nums[i] + temp, houseMid);
        }

        return houseMid;
    }
}
