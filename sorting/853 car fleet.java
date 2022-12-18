/*
https://leetcode.com/problems/car-fleet/description/

car joins fleet if behind another with later arrival -> sort list by position -> find increasing subsequence of arrival times FROM END TO START

time: O(n log n) -> sort the cars by position O(n log n) -> iterate from end to start O(n)
space: O(n) -> create a zipped array of position and speed O(n)
*/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double prev = 0;
        int fleets = 0;

        int[][] kinem = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            kinem[i] = new int[] { position[i], speed[i] };
        }

        Arrays.sort(kinem, (a, b) -> a[0] - b[0]);

        for (int i = kinem.length - 1; i >= 0; i--) {
            if (t(target, kinem[i]) > prev) {
                prev = t(target, kinem[i]);
                fleets++;
            }
        }

        return fleets;
    }

    private double t(int target, int[] kin) {
        return (double) (target - kin[0]) / kin[1];
    }
}
