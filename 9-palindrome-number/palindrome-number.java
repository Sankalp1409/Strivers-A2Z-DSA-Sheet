class Solution {
    public boolean isPalindrome(int x) {
        
        if(x<0)
            return false;
        
        Long originalNumber=(long)x;
        long rev=0;
        while(x>0)
        {
            int lastDigit=x%10;
            rev=rev*10+lastDigit;
            x/=10;
        }
        return rev==(long)originalNumber;
    }
}