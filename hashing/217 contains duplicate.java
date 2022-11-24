/*
https://leetcode.com/problems/contains-duplicate/description/

duplicate -> already in hash set -> return true

time: O(n) -> potentially add/lookup every element once
space: O(n) -> size of set
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
