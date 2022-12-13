/*
https://leetcode.com/problems/flower-planting-with-no-adjacent/description/

at most 3 paths to a garden => O(V) ~ O(E) -> create adjacency list -> check all neighboring gardens flower types -> greedily choose the first unused type

time: O(F|V|) -> adjacency list in O(|V|) -> for each garden/vertex O(|V|) -> greedily check flowers O(F)
space: O(|V|) -> adjacency list in O(|E|) ~ O(|V|) -> color labels for each garden O(|V|)
*/

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] color = new int[n];

        for (int i = 1; i <= n; i++) {
            map.put(i, new LinkedList<>());
        }

        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }

        for (int i = 1; i <= n; i++) {
            Set<Integer> neighbor_colors = new HashSet<>();
            for (int j : map.get(i)) {
                neighbor_colors.add(color[j - 1]);
            }

            for (int j = 1; j < 5; j++) {
                if (!neighbor_colors.contains(j)) {
                    color[i - 1] = j;
                    break;
                }
            }
        }
        return color;
    }
}
