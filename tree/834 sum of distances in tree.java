/*
https://leetcode.com/problems/sum-of-distances-in-tree/description/

pass one (post-order):
subt_SDT(u) = SUM_v subt_SDT(v) + |subt(v)| -> each node in subtr(v) gets extra edge from u-v -> solve subt_SDT for v then use to solve for u (recurse)

pass two (pre-order):
assume SDT(parent) correct -> SDT(par) is sum of SDT(u) + edge adjust |subtr(u)| -> SDT(u) is in sum of SDT(par) -> subtract |subt(u)| (extra edges TO par, dont need AT u) -> add n - |subt(u)| (extra edge for size of subt, parent of par) -> left with SDT(u) = sub(u) + SUM SDT from other subtrees/parent of par + edge adjustment to those subtrees/parent

time: O(|V| + |E|) -> postorder traversel to get subtree dist O(|V| + |E|) -> preorder traversal to get dist from parent O(|V| + |E|)
space: O(|V|) -> store |subtree(v)| and dist(v) for all v in V O(|V|)
*/

class Solution {
    int[] dist, children;
    List<Set<Integer>> adj;
    int n;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        dist = new int[n];
        children = new int[n];
        Arrays.fill(children, 1);
        adj = new ArrayList<>();
        this.n = n;

        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        numChildren(0, -1);
        sumDist(0, -1);

        return dist;
    }

    private void numChildren(int node, int p) {
        for (int v : adj.get(node)) {
            if (v != p) {
                numChildren(v, node);
                children[node] += children[v];
                dist[node] += children[v] + dist[v];
            }
        }
    }

    private void sumDist(int node, int p) {
        for (int v : adj.get(node)) {
            if (v != p) {
                dist[v] = (dist[node] - children[v]) + (n - children[v]);
                sumDist(v, node);
            }
        }
    }
}
