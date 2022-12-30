/*
https://leetcode.com/problems/arranging-coins/description/

approach 1
k stairs = arithmetic progression of 1st k ints summed to n -> solve for k -> quadratic formula

time: O(1) -> quadratic formula
space: O(1) -> search pointers
*/

class Solution {
    public int arrangeCoins(int n) {
        return (int) (-1 + Math.floor(Math.sqrt(1 + 8 * (long) n))) / 2;
    }
}

/*
approach 2
binary search on arithmetic progression -> sum is known, search for sequence size (# stairs)

time: O(log n) -> binary search on stair number O(log n) -> arithmetic sum O(1)
space: O(1) -> search pointers
*/

class Solution {
    public int arrangeCoins(int n) {
        long l = 0;
        long r = n;

        while (l <= r) {
            long mid = l + (r - l) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum == n) {
                return (int) mid;
            }
            else if (sum < n) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return (int) r;
    }
}
