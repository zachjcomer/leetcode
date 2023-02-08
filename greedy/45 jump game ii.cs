/*
https://leetcode.com/problems/jump-game-ii/

greedily search all spots reachable from i -> take the one that reaches the furthest spot

time: O(n) -> search from current O(k) -> move to result O(1) -> sum of k = n
space: O(1) -> pointers for jump distances
*/

public class Solution {
    public int Jump(int[] nums) {
        int i = 0;
        int count = 0;

        while (i < nums.Length - 1) {
            int next = 0;
            int best = 0;

            for (int jDist = 1; jDist <= nums[i]; jDist++) {
                if (i + jDist >= nums.Length - 1) {
                    next = nums.Length - 1;
                    break;
                }

                int potential = i + jDist + nums[i + jDist];
                if (potential > best) {
                    best = potential;
                    next = i + jDist;
                }

            }

            i = next;
            count++;
        }

        return count;
    }
}
