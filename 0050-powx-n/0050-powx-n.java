class Solution {
    
    public double myPow(double x, int p) {
        
        long n=p;
        boolean isNegative=false;
        if(n<0)
        {
            isNegative=true;
            n*=-1;
        }
        double ans=1.0;
        while(n>0)
        {
            if(n%2==0)
            {
                x= x*x;
                n/=2;
            }
            else
            {
                ans=ans*x;
                n--;
            }
        }
        if(isNegative)
            return 1.0/ans;
        return ans;
    }
}