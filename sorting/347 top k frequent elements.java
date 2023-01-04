/*
https://leetcode.com/problems/top-k-frequent-elements/description/

get the frequency of each element -> do a quickselect to get the k-th most common element

time: O(n) -> frequency hash O(n) -> quickselect k O(n)
space: O(n) -> hash for frequency O(n) -> quickselect in place O(1)
*/

class Solution {
    int[] unique;
    Map<Integer, Integer> count;
    public int[] topKFrequent(int[] nums, int k) {

        count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        unique = new int[count.size()];
        int j = 0;
        for (int num : count.keySet()) {
            unique[j] = num;
            j++;
        }

        quickselect(0, count.size(), k);

        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = unique[i];
        }
        
        return out;
    }

    private void quickselect(int l, int r, int k) {
        if (l == r) {
            return;
        }

        int piv = partition(l, r);
        if (piv == k) {
            return;
        }
        else if (piv < k) {
            quickselect(piv + 1, r, k);
        }
        else {
            quickselect(l, piv, k);
        }
    }

    private int partition(int l, int r) {
        int piv = l;

        int freq = count.get(unique[piv]);
        swap(piv, r - 1);
        int cur = l;

        for (int i = l; i < r; i++) {
            if (count.get(unique[i]) > freq) {
                swap(i, cur);
                cur++;
            }
        }

        swap(r - 1, cur);

        return cur;
    }

    private void swap(int i, int j) {
        int temp = unique[i];
        unique[i] = unique[j];
        unique[j] = temp;
    }
}
