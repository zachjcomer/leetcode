/*
https://leetcode.com/problems/all-paths-from-source-to-target/description/

graph is a DAG -> all paths from src to targ = all topological orderings src to targ -> DFS from src and build paths -> if node is target, add path to output

time: O(|E| + 2^(N - 2) * |V|) -> general DAG has 2^(N-2) choices for paths between nodes -> must travel all edges in DFS
space: O(2^(N - 2) * |V|) -> height of recursive stack O(|V|) -> number of possible paths stored O(2^(N-2) * |V|)
*/

class Solution {
    int targ;
    List<List<Integer>> out;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        out = new ArrayList<>();
        targ = graph.length - 1;
        List<Integer> path = new ArrayList<>();

        DFS(graph, 0, 0, path);

        return out;
    }

    private void DFS(int[][] graph, int u, int e, List<Integer> path) {
        while (path.size() > e) {
            path.remove(path.size() - 1);
        }
        if (path.size() == e) {
            path.add(0);
        }
        path.set(e, u);

        if (u == targ) {
            List<Integer> newPath = new ArrayList<>(path);
            out.add(newPath);
        }
        else {
            e++;
            for (int v : graph[u]) {
                DFS(graph, v, e, path);
            }
        }
    }
}
