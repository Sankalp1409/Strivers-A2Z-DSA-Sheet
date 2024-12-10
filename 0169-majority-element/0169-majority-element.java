class Solution {
    public int majorityElement(int[] nums) {
        
        int count=0;
        int ele=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
            {
                ele=nums[i];
                count=1;
            }
            else if(ele==nums[i])
                count++;
            else
                count--;
        }
        count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==ele)
                count++;
        }
        return count>nums.length/2 ? ele:-1;
    }
}