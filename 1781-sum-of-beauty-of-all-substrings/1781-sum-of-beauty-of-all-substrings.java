class Solution {
    public int beautySum(String s) {
        
        int ans=0;
        
        for(int i=0;i<s.length();i++)
        {
            int []count=new int[26];
            
            for(int j=i;j<s.length();j++)
            {                
                int maxi=Integer.MIN_VALUE;
                int mini=Integer.MAX_VALUE;
                count[s.charAt(j)-'a']++;
                for(int k=0;k<26;k++)
                {
                    if(count[k]!=0)
                    {
                        mini=Math.min(mini,count[k]);
                        maxi=Math.max(maxi,count[k]);
                    }
                }
                ans+=(maxi-mini);
            }
        }
        return ans;
    }
}