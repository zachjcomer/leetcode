/*
https://leetcode.com/problems/maximize-distance-to-closest-person/description/

approach 1: two pointers -> identify array bounds/occupied seats -> max dist = half dist between occupied seats OR entire interval if one bound is array end

time: O(n) -> check each seat to increase right bound or shift left start O(n)
space: O(1) -> max length value
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int l = -1;
        int r = 0;

        int max_len = 0;

        while (l < seats.length) {
            // intersection with array bound, can use entire width
            if (l == -1 && seats[r] == 1 || r == seats.length && seats[l] == 1) {
                max_len = Math.max(max_len, r - l - 1);
                l = r;
            }
            // regular intersect, must be half of interval
            else if (seats[r] == 1) {
                max_len = Math.max(max_len, (r - l) / 2);
                l = r;
            }

            r++;
        }

        return max_len;
    }
}

/*
approach 2: for each empty seat, find the left/right distances to nearest seat -> if array edge, distance = inf -> take min of left/right distances -> compare to greatest distance seen

time: O(n^2) -> for every empty seat O(n) -> find the nearest occupied seat or array boundary O(n)
space: O(1) -> values for max distance and radii to seats/array edge
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int l = 1;
                int r = 1;
                // max left
                while (i - l >= 0 && seats[i - l] != 1) {
                    l++;
                }

                if (i - l < 0) {
                    l = Integer.MAX_VALUE;
                }
                
                // max right
                while (i + r < seats.length && seats[i + r] != 1) {
                    r++;
                }

                if (i + r == seats.length) {
                    r = Integer.MAX_VALUE;
                }

                maxDist = Math.max(
                    Math.min(l, r),
                    maxDist
                );
            } 
        }
        return maxDist;
    }
}
