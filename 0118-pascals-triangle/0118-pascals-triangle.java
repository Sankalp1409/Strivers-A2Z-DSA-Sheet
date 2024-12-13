class Solution {
    
    public List<Integer>findNthRow(int n)
    {
        List<Integer>ans=new ArrayList<>();
        int res=1;
        ans.add(res);
        for(int i=1;i<=n;i++)
        {
            res=res*(n-i+1);
            res=res/i;
            ans.add(res);
        }
        return ans;
    }
    
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>>ansList=new ArrayList<>();
        
        for(int i=0;i<numRows;i++)
        {
            List<Integer>temp=findNthRow(i);
            ansList.add(temp);
        }
        return ansList;
    }
}