/*
https://leetcode.com/problems/max-points-on-a-line/description/

for each point -> find the slope with each other point -> double hash (point to [slope) to count] -> if slope exists in point map, increase count -> take max of each point to count map

pro: dont have to worry about slope-intercept form
con: check each pair twice (a -> b and b -> a), getLine() will be Float.POSITIVE_INFINITY or Float.NEGATIVE_INFINITY if pt2[0] - pt1[0] is Float.NaN so must specially check those cases

time: O(n^2) -> get slope for all points pairs O(n^2) -> count point-slope occurence O(1)
space: O(n^2) -> map each point O(n) -> to a map of slopes w/ other points O(n)
*/

class Solution {
    public int maxPoints(int[][] points) {
        int max = 1;

        Map<Integer, Map<Float, Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(i, new HashMap<Float, Integer>());
            int[] pt1 = points[i];

            for (int j = 0; j < points.length && j != i; j++) {
                int[] pt2 = points[j];
                
                float s;
                if (pt1[0] != pt2[0]) {
                    s = getLine(pt1, pt2);
                } else {
                    s = Float.POSITIVE_INFINITY;
                }
                
                Map<Float, Integer> pointMap = map.get(i);
                pointMap.put(s, pointMap.getOrDefault(s, 0) + 1);

                max = Math.max(max, pointMap.get(s) + 1);
            }
        }

        return max;
    }

    private float getLine(int[] pt1, int[] pt2) {
        if (pt1[0] > pt2[0]) return getLine(pt2, pt1);

        return (pt2[1] - pt1[1]) / ((float) pt2[0] - pt1[0]);
    }
}
