class Solution {
    public List<Integer> majorityElement(int[] nums) {                                          
        
        int ele1=0,ele2=0;
        int count1=0,count2=0;
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(count1==0 && nums[i]!=ele2)
            {
                ele1=nums[i];
                count1++;
            }
            else if(count2==0 && nums[i]!=ele1)
            {
                ele2=nums[i];
                count2++;
            }
            else if(nums[i]==ele1)
                count1++;
            else if(nums[i]==ele2)
                count2++;
            else
            {
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==ele1) count1++;
            else if(nums[i]==ele2) count2++;
        }
        
        if(count1>nums.length/3 && count2>nums.length/3)
        {
            ans.add(ele1);
            ans.add(ele2);
        }
        else if(count1>nums.length/3)
            ans.add(ele1);
        else if(count2>nums.length/3)
            ans.add(ele2);
        return ans;
    }
}