class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = -1;
        for(int i = 0; i < prices.length-1; i++){
            if(min > prices[i]) min = prices[i];
            if((prices[i+1] - min) > maxProfit) maxProfit = prices[i+1] - min;
        }
        if(maxProfit <=0) return 0;

        return maxProfit;
    }
}
