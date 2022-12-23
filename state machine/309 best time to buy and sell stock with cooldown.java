/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

FSM: buy state: wait or finish cooldown -> sell state: wait or buy stock -> cooldown state: sell stock. buy/sell are maximums b/c optimizing buy/sell price. cooldown day creates time lag so can't buy/sell every single day. initial conds: buy @ 0 b/c no profit accumulated, sell @ -prices[0] b/c money after first possible buy, cool @ -inf bc cant start w cooldown

time: O(n) -> simulate buy/sell/cooldown each day
space: O(1) -> values for past day and current day values
*/

class Solution {
    public int maxProfit(int[] prices) {
        int oldBuy;
        int oldSell;
        int oldCool;
       
        int buy = 0;
        int sell = -1 * prices[0];
        int cool = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            oldBuy = buy;
            oldSell = sell;
            oldCool = cool;

            buy = Math.max(oldBuy, oldCool);
            sell = Math.max(oldSell, oldBuy - prices[i]);
            cool = oldSell + prices[i];
        }

        return Math.max(buy, cool);
    }
}
