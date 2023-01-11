/*
https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

DFS on graph -> if node has apple or descendant has apple, add 2 to time (included in path to an apple) -> sum child time w/ DFS

time: O(n + |E|) -> create graph O(n + |E|) -> graph DFS O(n + |E|)
space: O(n|E|) -> size of adj O(n|E|) -> height of recursive stack O(n)
*/

class Solution {
    List<Integer>[] adj;
    List<Boolean> apples;
    boolean[] seen;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        seen = new boolean[n];
        apples = hasApple;
        adj = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        int out = DFS(0);
        return out;
    }

    private int DFS(int n) {
        seen[n] = true;
        int out = 0;
        for (int c : adj[n]) {
            if (!seen[c]) {
                out += DFS(c);
            }
        }
        
        if (n != 0 && (apples.get(n) || out > 0)) {
            return 2 + out;
        } else {
            return out;
        }
    }
}
