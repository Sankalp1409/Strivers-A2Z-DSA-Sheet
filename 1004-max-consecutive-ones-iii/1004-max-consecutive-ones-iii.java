class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int len=0;
        int i=0,j=0;
        int numberOfFlip=0;
        while(j<nums.length)
        {
            if(nums[j]==0)
                numberOfFlip++;
            
            while(numberOfFlip>k)
            {
                if(nums[i]==0)
                    numberOfFlip--;
                i++;
            }
            len=Math.max(len,j-i+1);
            j++;
        }
        return len;
    }
}