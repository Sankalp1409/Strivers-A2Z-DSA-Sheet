class Solution {
    
    public void solve(int idx,int k, int n,List<Integer>temp,List<List<Integer>>ansList)
    {
        if(k==0 && n==0)
        {
            ansList.add(new ArrayList<>(temp));
        }
        
        for(int i=idx;i<=9;i++)
        {
            if(n<i) continue;
            temp.add(i);
            solve(i+1,k-1,n-i,temp,ansList);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>ansList=new ArrayList<>();
        
        solve(1,k,n,temp,ansList);
        return ansList;
        
    }
}