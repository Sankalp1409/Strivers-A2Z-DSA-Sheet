class Solution {
    public boolean checkPerfectNumber(int num) {
        
        if(num==1)
            return false;
        int sum=1;
        int originalNumber=num;
        for(int i=2;i<=Math.sqrt(num);i++)
        {
            if(num%i==0)
            {
                if(i*i==num)
                    sum+=i;
                else
                    sum=sum+i+(num/i);
            }
        }
        return sum==originalNumber;
    }
}