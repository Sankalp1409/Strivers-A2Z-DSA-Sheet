class Solution {
    
    public boolean isPossible(int []nums, int k, int mid)
    {
        int sum=0;
        int partition=1;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>mid) return false;
            if(sum+nums[i]<=mid)
                sum+=nums[i];
            else
            {
                sum=nums[i];
                partition++;
            }
        }
        return partition<=k;
    }
    
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int i:nums)
            high+=i;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(isPossible(nums,k,mid))
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}