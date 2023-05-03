/*
https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

put each array into a set -> compare each set to the other -> results are not owned, must clone -> collect the results

time: O(max(n, m)) -> build each set O(n), O(m) -> compare sets O(n), O(m)
space: O(max(n, m)) -> each set O(n), O(m) -> each diff vec O(n), O(m)
*/

use std::collections::HashSet;
use std::iter::FromIterator;

impl Solution {
    pub fn find_difference(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<Vec<i32>> {
        let set_a: HashSet<i32> = HashSet::from_iter(nums1);
        let set_b: HashSet<i32> = HashSet::from_iter(nums2);

        let dif_a = set_a.difference(&set_b).cloned().collect();
        let dif_b = set_b.difference(&set_a).cloned().collect();

        vec![dif_a, dif_b]
    }
}
