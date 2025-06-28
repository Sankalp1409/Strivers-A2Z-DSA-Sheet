class Solution {
    public int majorityElement(int[] nums) {
        int possibleAnswer=-1;
        int count=0;

        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
            {
                possibleAnswer=nums[i];
                count++;
            }
            else if(possibleAnswer==nums[i])
                count++;
            else
                count--;
        }
        return possibleAnswer;
    }
}