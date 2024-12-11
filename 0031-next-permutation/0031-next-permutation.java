class Solution {
    public void nextPermutation(int[] nums) {
        
        int index1=-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                index1=i;
                break;
            }
        }
        
        if(index1==-1)
        {
            Arrays.sort(nums);
            return ;
        }
        
        int value=nums[index1+1];
        int index2=index1+1;
        
        for(int i=index1+1;i<nums.length;i++)
        {
            if(nums[i]>nums[index1] && nums[i]<value)
            {
                value=nums[i];
                index2=i;
            }
        }
        
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
        
        Arrays.sort(nums,index1+1,nums.length);
    }
}