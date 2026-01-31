class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []ansArray=new int[2];
        Map<Integer,Integer>mp=new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(mp.containsKey(target-nums[i]))
            {
                ansArray[0]=i;
                ansArray[1]=mp.get(target-nums[i]);
                break;
            }
            mp.put(nums[i],i);
        }
        return ansArray;
    }
}