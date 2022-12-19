/*
https://leetcode.com/problems/rectangle-area/description/

find intersection bounds -> if intersection exists, find its area -> return rect areas - intersection 

time: O(1) -> calculate intersection bounds O(1) -> calculate areas O(1)
space: O(1) -> value for intersection area O(1)
*/

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rect_inter = 0;

        int y_top = Math.min(ay2, by2);
        int y_bottom = Math.max(ay1, by1);
        int x_left = Math.max(ax1, bx1);
        int x_right = Math.min(ax2, bx2);

        // rects must overlap to count
        if (y_top > y_bottom && x_right > x_left) {
            rect_inter = (y_top - y_bottom) * (x_right - x_left);
        }

        return (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1) - rect_inter;

    }
}
