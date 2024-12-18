class Solution {
    public int[] finalPrices(int[] prices) {
        
        Stack<Integer>st=new Stack<>();
        int []nse=new int[prices.length];
        for(int i=prices.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek() > prices[i])
                st.pop();
            
            if(st.isEmpty() || st.peek()>prices[i])
                nse[i]=0;
            else
                nse[i]=st.peek();
            st.push(prices[i]);
        }
        
        int []ans=new int[prices.length];
        
        for(int i=0;i<prices.length;i++)
            ans[i]=prices[i]-nse[i];
        
        return ans;
        
    }
}