class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>>ansList=new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            int target=-nums[i];
            int j=i+1;
            int k=nums.length-1;
            
            while(j<k)
            {
                if(nums[j]+nums[k]==target)
                {
                    List<Integer>temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ansList.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    while(j<k && nums[k]==nums[k+1])
                        k--;
                }
                else if(nums[j]+nums[k]>target)
                    k--;
                else
                    j++;
            }
        }
        
        return ansList;
    }
}