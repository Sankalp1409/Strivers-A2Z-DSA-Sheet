class Solution {
    
    public void solve(int []nums, int idx, List<Integer>temp,List<List<Integer>>ansList)
    {
        ansList.add(new ArrayList<>(temp));
        
        for(int i=idx;i<nums.length;i++)
        {
            if(i!=idx && nums[i]==nums[i-1])
                continue;
            temp.add(nums[i]);
            solve(nums,i+1,temp,ansList);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>ansList=new ArrayList<>();
        
        solve(nums,0,temp,ansList);
        return ansList;
    }
}