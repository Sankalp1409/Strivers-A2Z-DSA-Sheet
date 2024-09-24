class Solution {
    
    public void solve(int []nums, int idx,List<Integer>temp,List<List<Integer>>ansList)
    {
        if(idx==nums.length)
        {
            if(!ansList.contains(temp))
                ansList.add(new ArrayList<>(temp));
            return ;
        }
        
        // notTake
        solve(nums,idx+1,temp,ansList);
        
        // take
        temp.add(nums[idx]);
        solve(nums,idx+1,temp,ansList);
        temp.remove(temp.size()-1);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>>ansList=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        solve(nums,0,temp,ansList);
        return ansList;
    }
}