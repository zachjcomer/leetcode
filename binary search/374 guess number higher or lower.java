/*
https://leetcode.com/problems/guess-number-higher-or-lower/description/

the search area is halved with each guess -> binary search for the guess number

time: O(log n) -> binary search
space: O(1) -> search pointers
*/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0;
        int r = n;

        int mid = l + (r - l) / 2;
        while (guess(mid) != 0) {
            if (guess(mid) == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

            mid = l + (r - l) / 2;
        }

        return mid;
    }
}
