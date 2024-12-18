class Solution {
    
    public int findFirstOcc(int []nums, int target)
    {
        int low=0,high=nums.length-1;
        boolean flag=false;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(nums[mid]==target)
                flag=true;
            if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        if(flag==false) return -1;
        return low;
    }
    
    public int findLastOcc(int []nums, int target)
    {
        int low=0,high=nums.length-1;
        boolean flag=false;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(nums[mid]==target)
                flag=true;
            if(target>=nums[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        if(flag==false) return -1;
        return high;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int first=findFirstOcc(nums,target);
        int second=findLastOcc(nums,target);
        
        return new int[]{first,second};
    }
}