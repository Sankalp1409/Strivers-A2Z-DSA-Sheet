class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer>ansList=new ArrayList<>();
        int ele1=0,ele2=0;
        int count1=0,count2=0;
        
        //moore Voting algorithm
        for(int i=0;i<nums.length;i++)
        {
            if(count1==0 && nums[i]!=ele2)
            {
                ele1=nums[i];
                count1++;
            }
            else if(nums[i]==ele1)
                count1++;
            else if(count2==0 && nums[i]!=ele1)
            {
                ele2=nums[i];
                count2++;
            }
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

        // re-checking the possible ele1 && ele2
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==ele1)
                count1++;
            if(nums[i]==ele2)
                count2++;
        }
        if(count1==nums.length)
        {
            ansList.add(ele1);
            return ansList;
        }
        if(count2==nums.length)
        {
            ansList.add(ele2);
            return ansList;
        }
        if(count1>nums.length/3)
            ansList.add(ele1);
        if(count2>nums.length/3)
            ansList.add(ele2);
        
        return ansList;
    }
}