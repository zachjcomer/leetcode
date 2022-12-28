/*
https://leetcode.com/problems/binary-search/description/

init at ends of array -> calc mid -> if mid = target, return mid -> otherwise shrink window based on >/< target -> return -1 if l > r, means target not found

time: O(log n) -> search area divides in half each time O(n log n)
space: O(1) -> pointers for left, right, and midpoint
*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
