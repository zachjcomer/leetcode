/*
https://leetcode.com/problems/max-points-on-a-line/description/

for each point -> find the slope with each other point -> double hash (point to [slope) to count] -> if slope exists in point map, increase count -> take max of each point to count map

pro: dont have to worry about slope-intercept form
con: check each pair twice (a -> b and b -> a), getLine() will be Float.POSITIVE_INFINITY or Float.NEGATIVE_INFINITY if pt2[0] - pt1[0] is Float.NaN so must specially check those cases

time: O(n^2) -> get slope for all points pairs O(n^2) -> count point-slope occurence O(1)
space: O(n) -> map each point O(1) -> to a map of slopes w/ other points O(n)
*/

class Solution {
    public int maxPoints(int[][] points) {
        int out = 1;
        if (points.length == 1) {
            return out;
        }
        
        if (points.length > 1) {
            for (int i = 0; i < points.length; i++) {
                Map<Double, Integer> map = new HashMap<>();
                int[] pt1 = points[i];

                for (int j = 0; j < points.length; j++) {
                    if (i != j) {
                        int[] pt2 = points[j];
                        
                        double s = Math.atan2(pt2[1] - pt1[1], pt2[0] - pt1[0]);
                        map.merge(s, 1, Integer::sum);
                    } 
                }
                out = Math.max(out, Collections.max(map.values()) + 1);
            }
        }
        
        return out;
    }
}
