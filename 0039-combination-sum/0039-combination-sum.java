class Solution {
    
    public void solve(int []candidate,int target,List<Integer>temp,
                      List<List<Integer>>ans, int idx)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(temp));
            return ;
        }
        
        if(idx<0) return ;
        
        // take
        if(target>=candidate[idx])
        {
            temp.add(candidate[idx]);
            solve(candidate,target-candidate[idx],temp,ans,idx);
            temp.remove(temp.size()-1);
        }
        
        //notTake
        solve(candidate,target,temp,ans,idx-1);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        
        solve(candidates,target,temp,ans,candidates.length-1);
        return ans;
        
    }
}