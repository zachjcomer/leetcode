/*
https://leetcode.com/problems/top-k-frequent-elements/description/

use hash as freq map -> add unique elements of freq map to min heap of size k -> polling min heap when size > k leaves k largest elements in heap (heap top is smallest b/c min heap) -> transfer to array

time: O(n log k) -> frequency hash O(n) -> add freq map to min heap of size k O(n log k)
space: O(n) -> hash for frequency O(n) -> heap of size k, k <= n O(k)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for (int num : count.keySet()) {
            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] out = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            out[i] = heap.poll();
        }
        
        return out;
    }
}
