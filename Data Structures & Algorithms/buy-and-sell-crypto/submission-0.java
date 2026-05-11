class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];
        for(int num : prices){
            minPrice = Math.min(num, minPrice);
            profit = Math.max(profit, num - minPrice);
        }
        return profit;
    }
}
