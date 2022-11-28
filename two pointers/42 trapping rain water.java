/*
Approach 1: multi-pass with left/right pool identification
https://leetcode.com/problems/trapping-rain-water/description/

water trapped while leading edge < starting edge -> identify starting/leading edges -> get area
if edge[l] > all edge[i > l], doesnt identify leading edge, so run from other direction (from right)

time: O(n) -> two passes to find edges -> for each container, sum its area in a single pass -> T ~ 4n (two array passes, two passes/container -- identify and get area)
space: O(1) -> total area, pointers
*/

class Solution {
    public int trap(int[] height) {
        int total_area = 0;

        // run from left to detect left-max and symmetryic pools
        int l = 0;
        int r = height.length - 1;

        int l_max = height[l];
        int r_max = height[r];

        while (l < r) {
            if (l_max > r_max) {
                r--;
                r_max = Math.max(r_max, height[r]);
                total_area += r_max - height[r];
            }
            else {
                l++;
                l_max = Math.max(l_max, height[l]);
                total_area += l_max - height[l];
            }
        }

        return total_area;
    }
}

/*
Approach 2:
https://leetcode.com/problems/trapping-rain-water/description/

pointers at ends of fill area -> move shorter wall in to find higher wall -> add area adjacent to moved wall

time: O(n) -> one pass of moving container walls
space: O(1) -> wall maxes, fill area
*/

class Solution {
    public int trap(int[] height) {
        int total_area = 0;
        
        int l = 0;
        int r = height.length - 1;

        int l_max = height[l];
        int r_max = height[r];

        while (l < r) {
            if (l_max > r_max) {
                r--;
                r_max = Math.max(r_max, height[r]);
                total_area += r_max - height[r];
            }
            else {
                l++;
                l_max = Math.max(l_max, height[l]);
                total_area += l_max - height[l];
            }
        }

        return total_area;
    }
}
