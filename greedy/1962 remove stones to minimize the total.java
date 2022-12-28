/*
https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

approach 1: track qty of piles of all heights w/ array -> work from large to small -> split max possible @ size -> decrease k, subtract split from sum, update qty piles of split size

time: O(n) -> 
space: O(1) -> array size is max pile amount O(1)
*/

class Solution {
    public int minStoneSum(int[] piles, int k) {
        int[] numPiles = new int[10001];
        int sum = 0;

        for (int pile : piles) {
            sum += pile;
            numPiles[pile]++; // track # of each pile size
        }

        for (int i = 10000; i > 0 && k > 0; i--) {
            if (numPiles[i] > 0) {
                int amount = Math.min(k, numPiles[i]); // split as many piles as possible
                int split = i - (i / 2);
                sum -= amount * (i / 2);
                numPiles[split] += amount; // add # split to new size
                numPiles[i] -= amount; // remove # split from original size
                k -= amount; // subtract # splits
            }
        }

        return sum;
    }
}

/*
approach 2: put piles in a max heap -> poll largest pile and split it and offer it to heap -> do until no more splits allowed -> take sum of all in heap

time: O(n log n) -> build heap O(n log n) -> poll/split/push pile k times O(k log n) -> sum of elements O(n)
space: O(n) -> heap stores all piles O(n)
*/

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(piles).forEach(heap::offer);
        IntStream.range(0, k).forEach(i -> heap.offer(heap.peek() - (heap.poll() / 2)));

        return heap.stream().mapToInt(i -> i).sum();
    }
}
