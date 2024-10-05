class Solution {
    public int longestSubarray(int[] nums) {
        
        int i=0,j=0;
        int len=0;
        int removeZero=0;
        while(j<nums.length)
        {
            if(nums[j]==0)
                removeZero++;
            
            while(removeZero>1)
            {
                if(nums[i]==0)
                    removeZero--;
                i++;
            }
            len=Math.max(j-i+1,len);
            j++;
        }
        return len-1;
    }
}