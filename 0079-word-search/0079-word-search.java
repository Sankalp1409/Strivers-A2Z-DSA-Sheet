class Solution {
    
    public boolean solve(char [][]board, String word, int index, int i, int j,boolean [][]visit)
    {
        if(index==word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || 
           visit[i][j]==true || board[i][j]!=word.charAt(index))
            return false;
        
        visit[i][j]=true;
        index++;
        int dx[]={1,0,-1,0};
        int dy[]={0,-1,0,1};
        
        for(int idx=0;idx<4;idx++)
        {
            int newI=i+dx[idx];
            int newJ=j+dy[idx];
            
            if(solve(board,word,index,newI,newJ,visit))
                return true;
        }
        visit[i][j]=false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        
        int row=board.length;
        int col=board[0].length;
        
        boolean [][]visit=new boolean[row][col];
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(solve(board,word,0,i,j,visit))
                        return true;
                }
            }
        }
        
        return false;
    }
}