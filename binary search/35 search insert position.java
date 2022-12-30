/*
https://leetcode.com/problems/search-insert-position/description/

perform binary search -> return mid if target match -> else window converges to would-be index, return l, which is right of r

time: O(log n) -> binary search
space: O(1) -> search area pointers
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return l;
    }
}
