class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>>ansList=new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            
            for(int j=i+1;j<nums.length-2;j++)
            {
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                
                long sum=target-(long)(nums[i]+nums[j]);
                int k=j+1;
                int l=nums.length-1;

                while(k<l)
                {
                    if(nums[k]+nums[l]==sum)
                    {
                        List<Integer>temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ansList.add(temp);
                        k++;
                        l--;

                        while(k<l && nums[k]==nums[k-1])
                            k++;
                        while(k<l && nums[l]==nums[l+1])
                            l--;
                    }
                    else if(nums[k]+nums[l]>sum)
                        l--;
                    else
                        k++;
                }
            }
        }

        return ansList;
    }
}