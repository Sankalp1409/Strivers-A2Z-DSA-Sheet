class Solution {
    
    public int countSubArray(int []nums, int target)
    {
        if(target<0) return 0;
        int sum=0;
        int count=0;
        int i=0,j=0;
        
        while(j<nums.length)
        {
            sum+=nums[j];
            
            while(sum>target)
            {
                sum-=nums[i];
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubArray(nums,goal)-countSubArray(nums,goal-1);
    }
}