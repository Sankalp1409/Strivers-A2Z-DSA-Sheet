class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int minValue=nums[0];
        int maxValue=nums[nums.length-1];

        for(int i=minValue;i>1;i--)
        {
            if(minValue%i==0 && maxValue%i==0)
                return i;
        }
        return 1;
    }
}