/*
https://leetcode.com/problems/remove-element/description/

a quickselect -> if nums[i] != val, swap with index j, increment j -> otherwise go to next i -> puts all nums[i] != val on left, all nums[i] == val on right

time: O(n) -> single pass
space: O(1) -> quickselect in place O(1) -> pointer to swap index O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return j;
    }
}
