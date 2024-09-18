class Solution {
    
    private int len=0;
    private int index=-1;
    
    public void solve(String s, int left , int right)
    {
        while(left>=0 && right<s.length())
        {
            if(s.charAt(left)==s.charAt(right))
            {
                left--;
                right++;
            }
            else
            {
                if(right-left-1 > len)
                {
                    len=right-left-1;
                    index=left+1;
                }
                break;
            }
        }
        if(right-left-1 > len)
        {
            len=right-left-1;
            index=left+1;
        }
        
    }
    
    public String longestPalindrome(String s) {
        
        for(int i=0;i<s.length();i++)
        {
            //odd length check
            solve(s,i-1,i+1);
            
            //even length check
            solve(s,i,i+1);
        }
        
        return s.substring(index,index+len);
    }
}