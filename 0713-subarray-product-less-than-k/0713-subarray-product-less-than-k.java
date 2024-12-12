class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        long prod=1;
        int i=0,j=0;
        int count=0;
        while(j<nums.length)
        {
            prod*=nums[j];
            while(i<=j && prod>=k)
            {
                prod/=nums[i];
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
}