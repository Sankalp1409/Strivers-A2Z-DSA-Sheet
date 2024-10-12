class Solution {
    public boolean canJump(int[] nums) {
        
        int pos=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(i>pos)
                return false;
            pos=Math.max(nums[i]+i,pos);
        }
        return pos>=nums.length-1;
    }
}