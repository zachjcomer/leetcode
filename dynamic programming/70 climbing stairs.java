/*
https://leetcode.com/problems/climbing-stairs/description/

dp: # step k = #(k-1) + #(k-2) -> top. O = increasing k -> base: k_0 = 1, k_1 = 1 -> original: # step n

time: O(n) -> O(1) work/subprob, addition -> O(n) subprobs, all stairs up to n
space: O(1) -> space optimization: new step = sum of last two -> shift new to middle, middle to back
*/

class Solution {
    public int climbStairs(int n) {
        // # ways k = # ways k-1 + # ways k-2
        // ways 0 = 1
        // ways 1 = 1

        int steps_back = 1;
        int steps_middle = 1;

        for (int i = 2; i <= n; i++) {
            int temp = steps_back; // save val
            steps_back = steps_middle; // shift middle to back
            steps_middle = steps_middle + temp; // new = middle + back
        }

        return steps_middle;
    }
}
