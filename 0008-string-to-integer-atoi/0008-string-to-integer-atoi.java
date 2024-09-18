class Solution {
    public int myAtoi(String s) {
        
        if(s.length()==0)
            return 0;
        int index=0;
        long ans=0;
        while(index<s.length() && s.charAt(index)==' ')
        {
            index++;
        }
        if(index==s.length())
            return 0;
        int multiply=1;
        if(s.charAt(index)=='+')
            index++;
        else if(s.charAt(index)=='-')
        {
            multiply=-1;
            index++;
        }
        while(index<s.length() && s.charAt(index)=='0')
            index++;
        
        while(index<s.length())
        {
            if(s.charAt(index)>='0' && s.charAt(index)<='9')
            {
                int val=s.charAt(index)-'0';
                ans=ans*10+val;
                if(ans>=Integer.MAX_VALUE)
                    break;
            }
            else
                break;
            index++;
        }
        
        ans*=multiply;
        if(ans>=Integer.MAX_VALUE)
            ans=Integer.MAX_VALUE;
        if(ans<=Integer.MIN_VALUE)
            ans=Integer.MIN_VALUE;
        return (int)ans;
    }
}