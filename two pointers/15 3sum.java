/*
https://leetcode.com/problems/3sum/description/
how to convert set to list https://docs.oracle.com/javase/8/docs/api/java/util/Set.html

for each starting point i, find unique combos (i, l, r) that add to 0 -> two pointers on array beyond i

time: O(n^2) -> sort O(n log n) -> fix i O(n) * two pointers one-pass on remaining O(n)
space: O(k) -> set of triples scales with values of entries, not length of input
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new LinkedList<>();

        Arrays.sort(nums); // brute force without sorting would be O(n^3)? so give 'er a good ole sort

        int i = 0;
        while (i < nums.length && nums[i] <= 0) { // sorted -- no combo can add to 0 once i (starting point) is positive
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r && nums[i] + nums[l] <= 0) {
                if (nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                    while (r > l && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
                else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
                else {
                    out.add(Arrays.asList(new Integer[] {nums[i], nums[l], nums[r]}));
                    
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    r--;
                    while (r > l && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }

            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return out;
    }
}
