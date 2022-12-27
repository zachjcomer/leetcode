/*
https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/

create array of unfilled spots per bag -> sort unfilled spots array -> greedily fill the bags that have the fewest unfilled spots until all are filled or no rocks remain

time: O(n log n) -> create unfilled array O(n) -> sort unfilled O(n log n) -> greedy fill unfilled bags O(n)
space: O(n) -> unfilled array O(n) -> values for filled bags, current index O(1)
*/

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] fill = new int[n];
        for (int i = 0; i < n; i++) {
            fill[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(fill);

        int bags = 0;
        int bag = 0;

        while (fill[bag] == 0) {
            bag++;
            bags++;
        }

        while (additionalRocks > 0 && bag < n) {
            if (fill[bag] <= additionalRocks) {
                additionalRocks -= fill[bag];
                fill[bag] = 0;
                bag++;
                bags++;
            } else {
                break;
            }
        }

        return bags;
    }
}
