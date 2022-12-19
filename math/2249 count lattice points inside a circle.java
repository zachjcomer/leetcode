/*
https://leetcode.com/problems/count-lattice-points-inside-a-circle/description/

for each circle -> check each lattice vector within bounding square -> add LVs within radius to a set

time: O(nr^2) -> n circles O(n) -> r^2 points to check O(r^2) -> check euclidean distance O(1)
space: O(nr^2) -> n circles, r^2 points per circle
*/

class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();

        for (int[] c : circles) {
            int x = c[0];
            int y = c[1];
            int r = c[2];

            for (int i = y - r; i <= y + r; i++) {
                for (int j = x - r; j <= x + r; j++) {
                    if (euclid(j, i, c) <= c[2]) {
                        set.add(j + "," + i);
                    }
                }
            }
        }

        return set.size();
    }

    private double euclid(int ax, int ay, int[] c) {
        int bx = c[0];
        int by = c[1];
        return Math.sqrt(((ax - bx) * (ax - bx)) + ((ay - by) * (ay - by)));
    }
}
