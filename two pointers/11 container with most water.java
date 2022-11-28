/*
https://leetcode.com/problems/container-with-most-water/description/

area is min wall height times width -> two pointers from array ends -> replace wall that is shorter

time: O(n) -> one pass of two pointers
space: O(1) -> max water
*/

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {
            int cur = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, cur);

            if (height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }

        return max;
    }
}
