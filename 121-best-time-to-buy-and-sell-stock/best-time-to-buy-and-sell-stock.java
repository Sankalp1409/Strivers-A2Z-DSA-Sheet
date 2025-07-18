class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;

        int buy=prices[0];
        int maxProfit=0;

        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<buy)
                buy=prices[i];

            maxProfit=Math.max(maxProfit,prices[i]-buy);
        }
        return maxProfit;
    }
}