class Solution {
    
    int mod=1000000007;
    public long power(long val, long p)
    {
        if(p==0)
            return 1;
        
        long ans=power(val,p/2);
        if(p%2==0)
            return (ans*ans)%mod;
        else
            return (ans*ans*val) %mod;
    }
    
    public int countGoodNumbers(long n) {
        
        if(n==1)
            return 5;
        
        long evenPosition=(n+1)/2;
        long oddPosition=n/2;
        
        return (int)(power(5,evenPosition)*power(4,oddPosition)%mod);
    }
}