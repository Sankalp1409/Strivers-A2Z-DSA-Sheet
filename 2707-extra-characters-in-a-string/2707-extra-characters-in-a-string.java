class Solution {
    
    public int solve(String s, int idx, Set<String>st, int dp[])
    {
        if(idx==s.length())
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int mini=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++)
        {
            int extra=0;
            String str=s.substring(idx,i+1);
            if(!st.contains(str))
                extra=str.length();
            
            // System.out.println(str);
            
            int remaining=solve(s,i+1,st,dp);
            mini=Math.min(mini,extra+remaining);
        }
        return dp[idx]=mini;
    }
    public int minExtraChar(String s, String[] dictionary) {
        
        Set<String>st=new HashSet<>();
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        for(String word:dictionary)
            st.add(word);
        
        return solve(s,0,st,dp);
        
    }
}