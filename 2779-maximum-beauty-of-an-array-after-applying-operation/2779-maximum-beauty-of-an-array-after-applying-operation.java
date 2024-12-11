class Solution {
    
    public int binarySearch(int []nums, int key)
    {
        int low=0,high=nums.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(nums[mid]<=key)
                low=mid+1;
            else
                high=mid-1;
        }
        return high;
    }
    
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int result=1;
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            int y=x+2*k;
            
            int j=binarySearch(nums,y);
            
            result=Math.max(result,j-i+1);
        }
        return result;
    }
}