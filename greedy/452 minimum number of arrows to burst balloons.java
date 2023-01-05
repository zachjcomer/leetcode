/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

greedy -> sort by balloon starting x -> add as many balloons as possible to current group (they start before current end) -> add a group when this is not true and begin a new group

time: O(n log n) -> sort balloons by starting position O(n log n)
space: O(1) -> pointer for current group end
*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        int out = 1;
        int end = 0;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[end][1]) {
                out++;
                end = i;
            }
        }

        return out;
    }
}
