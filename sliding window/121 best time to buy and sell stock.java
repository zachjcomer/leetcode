/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

find a local minimum (buy price) -> sell at proceeding values -> switch to new local minima -> return greatest difference

time: O(n) -> compare current price to buy price or switch buy price
space: O(1) -> max profit, buy price
*/

class Solution {
    public int maxProfit(int[] prices) {
        int m = 0;
        int b = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < b) {
                b = prices[i];
            }
            else if (prices[i] - b > m) {
                m = prices[i] - b;
            }
        }

        return m;
    }
}
