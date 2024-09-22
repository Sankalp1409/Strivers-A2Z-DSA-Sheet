class Solution {
    
    public void solve(int []nums, int idx,List<Integer>list, List<List<Integer>>ansList)
    {
        if(idx==nums.length)
        {
            ansList.add(new ArrayList<>(list));
            return ;
        }
        
        // pick
        list.add(nums[idx]);
        solve(nums,idx+1,list,ansList);
        list.remove(list.size()-1);
        
        // not pick
        solve(nums,idx+1,list,ansList);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer>list=new ArrayList<>();
        List<List<Integer>> ansList=new ArrayList<>();
        
        solve(nums,0,list,ansList);
        return ansList;
    }
}