class Solution {
    public int alternatingSubarray(int[] nums) {
        int len=-1;
        int i=0,j=1;
        boolean check=true;
        while(j<nums.length)
        {
            int prev=nums[j-1];
            int curr=nums[j];
            
            if(check)
            {
                if(curr-prev==1)
                {
                    check=false;
                    len=Math.max(len,j-i+1);
                }
                else
                {
                    i=j;
                }
            }
            else
            {
                if(curr-prev==-1)
                {
                    check=true;
                    len=Math.max(len,j-i+1);
                }
                else if(curr-prev==1)
                {
                    i=j-1;
                    len=Math.max(len,j-i+1);
                }
                else
                {
                    check=true;
                    i=j;
                }
            }
            j++;
        }
        return len;
    }
}