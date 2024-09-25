class Solution {
    
    public void solve(char [][]board, int n, int col,
                      boolean []rc, boolean []ld, boolean []ud,List<List<String>>ans)
    {
        if(col==n)
        {
            ans.add(construct(board));
            return ;
        }
        
        for(int i=0;i<n;i++)
        {
            if(rc[i]==false && ud[i+col]==false && ld[n+(col-i)]==false)
            {
                board[i][col]='Q';
                rc[i]=true;
                ud[i+col]=true;
                ld[n+(col-i)]=true;
                
                solve(board,n,col+1,rc,ld,ud,ans);
                board[i][col]='.';
                rc[i]=false;
                ud[i+col]=false;
                ld[n+(col-i)]=false;
            }
        }
    }
    
    public List<String> construct(char[][]board)
    {
        
        List<String> list=new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            String ans="";
            for(int j=0;j<board[0].length;j++)
            {
                ans+=board[i][j];
            }
            list.add(ans);
        }
        return list;
    }
    
    public List<List<String>> solveNQueens(int n) {
        
        char [][]board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                board[i][j]='.';
        }
        boolean []rc=new boolean[n];
        boolean []ld=new boolean[2*n+2];
        boolean []ud=new boolean[2*n+1];
        List<List<String>>ans=new ArrayList<>();
        solve(board,n,0,rc,ld,ud,ans);
        return ans;
        
    }
}