class Solution {
    public int countDigits(int num) {
        int count=0;
        int originalNumber=num;
        while(num>0)
        {
            int lastDigit=num%10;
            if(originalNumber%lastDigit==0)
            {
                count++;
            }
            num/=10;
        }
        return count;
    }
}