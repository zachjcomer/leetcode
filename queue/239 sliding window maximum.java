/*
https://leetcode.com/problems/sliding-window-maximum/description/
deque ops https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html

deque by index -> poll from front if not in window -> poll from end if smaller than added value (smaller things in deque before added can never be the window max)

time: O(n) -> single pass O(n) -> poll front O(1) -> add end O(1)
space: O(k) -> deque may never have more than k entries (others get polled from front for index or end for nums[index] being small)
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int[] max_window = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            max_window[i] = nums[dq.peekFirst()];
        }

        // first k - 1 windows arent valid windows, discard
        return Arrays.copyOfRange(max_window, k - 1, nums.length);
    }
}
