/*
https://leetcode.com/problems/koko-eating-bananas/description/

optimizing a mono seq w/ binary search -> mid = eating rate -> if mid invalid, incr left, if mid valid, dec right but KEEP MID (mid could be optimal soln) -> window converges on optimal soln

time: O(n log h) -> binary search over eating rate O(log h) -> calculate eating rate O(n)
space: O(1) -> binary search pointers
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MAX_VALUE;

        while (l < r) {
            int mid = l + (r - l) / 2;

            int t = 0;
            for (int pile : piles) {
                t += pile / mid;
                if (pile % mid != 0) {
                    t++;
                }
            }

            if (t > h) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }

        return r; // ordinarily would need to post process, but r + 1
    }
}
