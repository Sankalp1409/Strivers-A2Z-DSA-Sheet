class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int []ansArray=new int[nums.length];
        int pos=0,neg=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                ansArray[pos]=nums[i];
                pos+=2;
            }
            else
            {
                ansArray[neg]=nums[i];
                neg+=2;
            }
            
        }
        return ansArray;
        
    }
}