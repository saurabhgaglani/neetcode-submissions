class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length-1; i++){
            if(min > prices[i]) min = prices[i];
            maxProfit = Math.max(maxProfit, prices[i+1] - min);
        }

        return maxProfit;
    }
}
