/*
https://leetcode.com/problems/product-of-array-except-self/submissions/

prod of everything left and right of i -> pass one: cumulative product from left -> pass two: right cumulative TIMES result from left product

time: O(n) -> two-pass multiplication
space: O(n) -> not in place, uses buffer
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] out = new int[nums.length];

       int prod = 1; // identity
       for (int i = 0; i < nums.length; i++) {
           out[i] = prod; // = bc entirely represented by prod
           prod *= nums[i];
       }

       prod = 1;
       for (int i = nums.length - 1; i >= 0; i--) {
           out[i] *= prod; // *= bc must multiply by left product
           prod *= nums[i];
       }

       return out;
    }
}
