/*
https://leetcode.com/problems/shuffle-the-array/description/

iterate over array -> maintain pointers to shuffle locations -> map relevant shuffle to appropriate index

time: O(n) -> pass over nums O(n) -> determine shuffle O(1) -> increment pointers O(1)
space: O(n) -> new array to hold shuffle O(n)
*/

public class Solution {
    public int[] Shuffle(int[] nums, int n) {
        int[] shuf = new int[2 * n];
        int j = 0;

        for (int i = 0; i < nums.Length; i++) {
            if (i % 2 == 0) {
                shuf[i] = nums[j];
                j++;
            } else {
                shuf[i] = nums[n];
                n++;
            }
        }

        return shuf;
    }
}
