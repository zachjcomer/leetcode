/*
https://leetcode.com/problems/count-lattice-points-inside-a-circle/description/

approach 1: for each circle -> check each lattice vector within bounding square -> add LVs within radius to a set
approach 2: same as first, but use 202x202 array to annotate points -> iterate over array and count number of nonzero values

time: O(nr^2) -> n circles O(n) -> r^2 points to check O(r^2) -> check euclidean distance O(1)
space: O(nr^2) -> n circles, r^2 points per circle for approach 1 / O(1) space (202x202 array) for approach 2
*/

// approach 1
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

// approach 2
class Solution {
    public int countLatticePoints(int[][] circles) {
        int[][] pts = new int[202][202];

        for (int[] c : circles) {
            int x = c[0];
            int y = c[1];
            int r = c[2];

            for (int i = y - r; i <= y + r; i++) {
                for (int j = x - r; j <= x + r; j++) {
                    if (euclid(j, i, c) <= c[2]) {
                        pts[i][j]++;
                    }
                }
            }
        }

        int count = 0;
        for (int[] row : pts) {
            for (int i : row) {
                if (i > 0) count++;
            }
        }

        return count;
    }

    private double euclid(int ax, int ay, int[] c) {
        int bx = c[0];
        int by = c[1];
        return Math.sqrt(((ax - bx) * (ax - bx)) + ((ay - by) * (ay - by)));
    }
}
