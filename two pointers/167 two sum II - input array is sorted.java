/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

numbers[i] + numbers[j] -> less than target = increase i, greater than target = decrease j

time: O(n) -> single pass of the array
space: O(1) -> two pointers for current numbers
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while ((numbers[i] + numbers[j] != target)) {
            // sum too low, increase left
            if (numbers[i] + numbers[j] < target) {
                i++;
                // skip trivial comparisons
                while (numbers[i] == numbers[i - 1]) {
                    i++;
                }
            }
            // too high, decrease right
            else if (numbers[i] + numbers[j] > target) {
                j--;
                // skip trivial comparisons
                while (numbers[j] == numbers[j + 1]) {
                    j--;
                }
            }
        }
        return new int[] {i + 1, j + 1};
    }
}
