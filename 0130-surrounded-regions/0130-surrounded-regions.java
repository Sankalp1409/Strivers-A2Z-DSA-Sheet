class Solution {
    
    public void DFS(char[][] board,boolean[][] visit,int x, int y)
    {
        visit[x][y]=true;
        
        int dx[]={1,0,-1,0};
        int dy[]={0,-1,0,1};
        
        for(int idx=0;idx<4;idx++)
        {
            int newx=x+dx[idx];
            int newy=y+dy[idx];
            
            if(newx>=0 && newx<board.length && newy>=0 && newy<board[0].length
                && board[newx][newy]=='O' && visit[newx][newy]==false)
                DFS(board,visit,newx,newy);
        }
    }
    
    public void solve(char[][] board) {
        
        int row=board.length;
        int col=board[0].length;
        
        boolean [][]visit=new boolean[row][col];
        for(int i=0;i<row;i++)
        {
            if(board[i][0]=='O' && visit[i][0]==false)
                DFS(board,visit,i,0);
            if(board[i][col-1]=='O' && visit[i][col-1]==false)
                DFS(board,visit,i,col-1);
        }
        for(int j=0;j<col;j++)
        {
            if(board[0][j]=='O' && visit[0][j]==false)
                DFS(board,visit,0,j);
            if(board[row-1][j]=='O' && visit[row-1][j]==false)
                DFS(board,visit,row-1,j);
            
        }
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(board[i][j]=='O' && visit[i][j]==false)
                    board[i][j]='X';
            }
        }
    }
}