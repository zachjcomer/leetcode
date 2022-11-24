/*
https://leetcode.com/problems/two-sum/description/

hash key, value (target - nums[i], i) -> check key nums[i] -> if existing key, value is index of complemnt, otherwise put in hash

time: O(n) -> look at every num once to find complementary number or add to hash
space: O(n) -> 1 unique solution => unique pairings -> O(n) nums put in hash
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // numA + numB = target?
        // target - numA = numB
        // hash = [target - numA -> index(numA)]
        // if numB in hash, return index(numB), hash(numB)

        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (diff.containsKey(nums[i])) {
                return new int[] {diff.get(nums[i]), i};
            }
            else {
                diff.put(target - nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}
