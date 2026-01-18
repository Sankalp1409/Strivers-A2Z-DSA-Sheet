class Solution {
    public int reverse(int x) {
        
        boolean isNegative=false;
        long rev=0;
        if(x==Integer.MIN_VALUE || x==Integer.MAX_VALUE)
            return 0;
        
        if(x<0)
        {
            isNegative=true;
            x*=-1;
        }

        while(x>0)
        {
            int lastDigit=x%10;
            rev=rev*10+lastDigit;
            if(rev>Integer.MAX_VALUE)
            {
                return 0;
            }
            x/=10;
        }
        if(isNegative)
        {
            rev=rev*-1;
            if(rev<Integer.MIN_VALUE)
                return 0;
        }
        return (int)rev;
    }
}