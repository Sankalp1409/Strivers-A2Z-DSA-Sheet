class Solution {
    
    public void solve(String temp, int open, int close, int n, List<String>ansList)
    {
        if(open==n && close==n)
        {
            ansList.add(temp);
            return;
        }
        
        if(open<=n)
            solve(temp+"(",open+1,close,n,ansList);
        if(open > close)
            solve(temp+")",open,close+1,n,ansList);
    }
    
    public List<String> generateParenthesis(int n) {
        
        String temp="";
        List<String>ansList=new ArrayList<>();
        solve(temp,0,0,n,ansList);
        return ansList;
    }
}