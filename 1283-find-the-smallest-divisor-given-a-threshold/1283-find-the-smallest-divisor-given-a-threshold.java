class Solution {
    
    public boolean isPossible(int[] nums, int mid, int threshold)
    {
        int count=0;
        
        for(int i=0;i<nums.length;i++)
        {
            count+=nums[i]/mid;
            if(nums[i]%mid!=0)
                count++;
        }
        return count<=threshold;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low=1;
        int high=0;
        for(int i:nums)
            high=Math.max(i,high);
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(isPossible(nums,mid,threshold))
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}