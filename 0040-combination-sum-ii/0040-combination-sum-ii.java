class Solution {
    
    public void solve(int []candidates, int target, 
                      List<Integer>temp,List<List<Integer>>ans,int idx)
    {
        
        if(target==0)
        {
            ans.add(new ArrayList<>(temp));
            return ;
        }
        
        for(int i=idx;i<candidates.length;i++)
        {
            if(i!=idx && candidates[i]==candidates[i-1])
                continue;
            
            // take 
            if(target>=candidates[i])
            {
                temp.add(candidates[i]);
                solve(candidates,target-candidates[i],temp,ans,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        solve(candidates,target,temp,ans,0);
        return ans;
    }
}