/*
https://leetcode.com/problems/top-k-frequent-elements/description/

heap solution: https://github.com/zachjcomer/leetcode/blob/master/heap/347%20top%20k%20frequent%20elements.java

approach 1: bucket sort with arrays
find range of possible nums -> count freq of nums -> put freqs into buckets -> for range of buckets (|nums|), add buckets to output array

pro: quicker to access freq, iterate over arrays
con: dealing with range of freq array, large range could cause overflow

time: O(n) -> range O(n) -> freq O(n) -> buckets O(n) -> output O(n)
space: O(max - min + n) -> freq array O(max - min) -> buckets O(n) -> output O(k)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] freq = new int[max - min + 1]; // +1 for 0
        for (int num : nums) {
            freq[num - min]++;
        }

        List<Integer>[] buckets = new LinkedList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            if (buckets[freq[i]] == null) {
                buckets[freq[i]] = new LinkedList<>();
            }

            buckets[freq[i]].add(i + min);
        }

        int[] out = new int[k];
        for (int i = nums.length, j = 0; i >= 0 && j < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    if (j == k) break;
                    out[j] = num;
                    j++;
                }
            }
        }
        return out;
    }
}

/*
approach 2: bucket sort with hash maps
use hash as freq map -> bucket nums entries by freq -> bucket keys are counts -> max count is |nums|, min is 0, so add to output list from max possible size to smallest -> convert to array of length k

pro: nums -> freq map -> bucket freqs -> list of length k is straightforward compared to others (and )
con: overhead with conversion to array, adding excess elements from bucket to output list

time: O(n) -> frequency hash O(n) -> bucket by freq O(n) -> buckets to output list O(n) -> list to array O(n)
space: O(n) -> hash for frequency O(n) -> buckets O(n) -> list O(n) -> output array O(k) 
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // nums to bucket
        List<Integer>[] buckets = new LinkedList[nums.length + 1];
        for (int num : count.keySet()) {
            int numCount = count.get(num);
            if (buckets[numCount] == null) {
                buckets[numCount] = new LinkedList<>();
            }
            buckets[numCount].add(num);
        }

        // buckets to list
        List<Integer> outList = new LinkedList<>();
        for (int i = nums.length; i >= 0; i--) {
            if (buckets[i] != null) {
                outList.addAll(buckets[i]);
            }
        }
        
        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = outList.get(i);
        }

        return out;
    }
}


/*
approach 3: quickselect
get the frequency of each element -> do a quickselect to get the k-th most common element

pro: sorting array in place
con: could be O(n^2) if quicksort pivots are bad, also the most opaque solution

time: O(n) -> frequency hash O(n) -> quickselect k O(n)
space: O(n^2) -> hash for frequency O(n) -> quickselect in place O(n^2) (usually O(n))
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
        int piv = l + (r - l) / 2;

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
