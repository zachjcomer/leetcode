/*
https://leetcode.com/problems/longest-consecutive-sequence/description/

sort array -> traverse in one pass -> count consecutive sequence -> compare to longest sequence seen

time: O(n log n) -> sort array in O(n log n), one pass sequence counting in O(n)
space: O(1) -> sorting done in-place
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        int cur = 0;
        int last = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == last) {
                i++;
            }
            else {
                if (nums[i] == last + 1) {
                    cur++;
                }
                else {
                    max = Math.max(cur, max);
                    cur = 1;
                }
                last = nums[i];
            } 
        }
        return Math.max(cur, max);
    }
}

/*
https://leetcode.com/problems/longest-consecutive-sequence/description/
hash at sequence beginning: https://leetcode.com/problems/longest-consecutive-sequence/solutions/127576/longest-consecutive-sequence/

add nums to set -> if i-1 not in set, i is start of sequence -> traverse from i until end -> dont traverse if i-1 is in set

time: O(n) -> add to set in O(n), traverse only if sequence start
space: O(n) -> adding nums to set
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
