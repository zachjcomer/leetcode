/*
https://leetcode.com/problems/maximum-ice-cream-bars/description/

sort costs -> iterate over costs -> greedily add costs and count each time a cone is bought -> continue until total costs exceeds coin amount

time: O(n log n) -> sort costs O(n log n) -> iterate over coins O(n)
space: O(1) -> coin coint O(1)
*/

impl Solution {
    pub fn max_ice_cream(mut costs: Vec<i32>, coins: i32) -> i32 {
        costs.sort_unstable();

        costs.iter()
            .scan(0, |x, cost| { *x += cost; Some(*x) })
            .take_while(|&x| x <= coins)
            .count() as i32
    }
}
