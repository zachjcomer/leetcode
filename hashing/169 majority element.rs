/*
https://leetcode.com/problems/majority-element/description/

approach 1: count the instances of each num in nums -> return num if its count is > len / 2

time: O(n) -> consider each num in nums once
space: O(n) -> hashing nums to their count
*/

use std::collections::HashMap;

impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        let n = nums.len() / 2;
        let mut map = HashMap::new();

        for num in nums {
            let count = match map.get(&num) {
                None => 1,
                Some(x) => x + 1,
            };

            if count > n {
                return num
            }

            map.insert(num, count);
        }
        0
    }
}

/*
approach 2: sort list then return element at index len / 2

time: O(n log n) -> sort list O(n log n) -> return elem at len / 2 O(1)
space: O(1) -> sort in place
*/

impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        nums.sort();
        return nums[nums.len() / 2]
    }
}
