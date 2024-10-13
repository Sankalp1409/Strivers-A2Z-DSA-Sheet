class Solution {
    public int jump(int[] nums) {
        
        int maxReach=0;
        int currReach=0;
        int jump=0;
        
        for(int i=0;i<nums.length-1;i++)
        {
            if(i>currReach)
                return 0;
            maxReach=Math.max(maxReach,nums[i]+i);
            if(i==currReach)
            {
                currReach=maxReach;
                jump++;
            }
        }
        
        return jump;
    }
}