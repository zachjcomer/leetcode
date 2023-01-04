/*
https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

sort the task list -> find the size of each task pool -> compute the minimum rounds for each pool -> sum the rounds over all pools

time: O(n log n) -> sorting O(n log n) -> find same-task size O(n) -> compute minimum rounds and sum O(1)
space: O(1) -> sum, two pointers O(1)
*/

class Solution {
    public int minimumRounds(int[] tasks) {
        int r = 0;
        int start = 0;
        int i = 0;
        Arrays.sort(tasks);

        while(i <= tasks.length) {
            while (i < tasks.length && (i == 0 || tasks[i] == tasks[i - 1])) {
                i++;
            }
            
            int t = i - start;

            if (t <= 1) return -1;

            r += t / 3;
            if (t % 3 != 0) {
                r++;
            }

            start = i;
            i++;
        }

        return r;
    }
}
