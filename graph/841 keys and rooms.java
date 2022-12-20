/*
https://leetcode.com/problems/keys-and-rooms/description/

room key = edge -> visit all rooms = single connected component -> perform single BFS and tally vertices -> single CC if tally = vertex set cardinality

time: O(|V| + |E|) -> BFS with queue O(|V| + |E|) -> check CC size O(1)
space: O(|V|) -> size of queue O(|V|), tally O(1)
*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] seen = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();

        int size = 0;
        seen[0] = 1;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            size++;
            
            for (int v : rooms.get(current)) {
                if (seen[v] == 0) {
                    seen[v] = 1;
                    queue.offer(v);
                }
            }
        }

        return size == rooms.size();
    }
}
