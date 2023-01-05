/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

greedy -> sort by balloon starting x -> add as many balloons as possible to current group (they start before current end) -> add a group when this is not true and begin a new group

time: O(n log n) -> sort balloons by starting position O(n log n)
space: O(1) -> pointer for current group end
*/

impl Solution {
    pub fn find_min_arrow_shots(mut points: Vec<Vec<i32>>) -> i32 {
        points.sort_unstable_by(|a, b| a[1].cmp(&b[1]));

        let mut out = 1;
        let mut end = points[0][1];

        for p in &points[1..] {
            if p[0] > end {
                out += 1;
                end = p[1];
            }
        }

        out
    }
}
