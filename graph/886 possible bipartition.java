/*
https://leetcode.com/problems/possible-bipartition/description/

perform a traversal -> alternate colorings -> if an adjacent node has already been colored with same color, graph is non-bipartite

time: O(|V| + |E|) -> Make graph O(|V| + |E|) -> DFS/BFS O(|V| + |E|)
space: O(|V| + |E|) -> storing edges in adjacency list O(|E|) -> store color annotation O(|V|)
*/

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] seen = new int[n + 1];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new LinkedList<>());
        }

        for (int[] edge : dislikes) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        int color;
        int oldColor;

        for (int i = 1; i <= n; i++) {
            if (seen[i] == 0) {
                stack.push(i);
                seen[i] = 1;

                while(!stack.isEmpty()) {
                    int current = stack.pop();

                    oldColor = seen[current];
                    if (oldColor == 1) {
                        color = -1;
                    } else {
                        color = 1;
                    }

                    if (map.containsKey(current)) {
                        for (int v : map.get(current)) {
                            if (seen[v] == oldColor) {
                                return false;
                            }
                            else if (seen[v] == 0) {
                                seen[v] = color;
                                stack.push(v);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
