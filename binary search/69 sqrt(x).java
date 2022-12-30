/*
https://leetcode.com/problems/sqrtx/description/

search sqrs -> find smallest sq >= x -> window converges to that sq -> x is a square return l, x is not a square return l - 1 (largest sq root w/ root^2 < x)

time: O(log n) -> binary search
space: O(1) -> search pointers
*/

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int l = 1;
        int r = x;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            System.out.printf("(%d, %d) -> %d\n", l, r, mid);
            
            if (mid < x / mid) { // want smallest square larger than target
                l = mid + 1;
            } 
            else { // else search smaller squares (mid^2 possibly correct, so keep in window)
                r = mid;
            }
        }
        
        return (l == x / l) ? l : l - 1; // exact root or round down
    }
}
