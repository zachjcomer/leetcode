/*
https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
converting set to array: https://www.techiedelight.com/convert-set-to-array-java/

loss = edge to vertex on graph of games played -> follow edges and tally in-degrees -> place in_deg 0, 1 in appropriate lists

Approach 1: HashMap
time: O(E + V log V) -> traverse all edges and count in-degree -> sort the hash's keySet
space: O(V) -> save in-degree for all nodes in hash map

Approach 2: Array Hash
time: O(E) -> count in-degree
space: O(1) -> array init to maximum possible input size
*/

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] in_degree = new int[100001];
        List<Integer> list0 = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();

        // count in degree for all V in O(E)
        for (int[] edge: matches) {
            if (in_degree[edge[0]] == 0) {
                in_degree[edge[0]] = -1; // root node
            }
            if (in_degree[edge[1]] <= 0) {
                in_degree[edge[1]] = 1; // in deg = 1
            }
            else {
                in_degree[edge[1]] = 2; // in deg > 1
            }
        }

        for (int i = 0; i <= 100000; i++) {
            if (in_degree[i] == -1) {
                list0.add(i);
            }
            else if (in_degree[i] == 1) {
                list1.add(i);
            }
        }

        List<List<Integer>> out = new LinkedList<>();
        out.add(list0);
        out.add(list1);

        return out;
    }
}

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> in_degree = new HashMap<>();
        List<List<Integer>> out = new LinkedList<>();
        out.add(new LinkedList<>());
        out.add(new LinkedList<>());

        for (int[] edge: matches) {
            in_degree.putIfAbsent(edge[0], 0);
            in_degree.put(edge[1], in_degree.getOrDefault(edge[1], 0) + 1);
        }

        for (int[] edge: matches) {
            if (in_degree.containsKey(edge[0]) && in_degree.get(edge[0]) > 1) {
                in_degree.remove(edge[0]);
            }
            if (in_degree.containsKey(edge[1]) && in_degree.get(edge[1]) > 1) {
                in_degree.remove(edge[1]);
            }
        }

        Integer[] keys = in_degree.keySet().toArray(new Integer[in_degree.keySet().size()]);
        Arrays.sort(keys);

        for (int i : keys) {
            if (in_degree.get(i) == 0) {
                out.get(0).add(i);
            }
            else {
                out.get(1).add(i);
            }
        }

        return out;
    }
}
