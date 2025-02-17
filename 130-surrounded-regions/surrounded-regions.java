class Solution {

    public void DFS(char [][]board,int i, int j , boolean [][]visit)
    {
        visit[i][j]=true;

        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};

        for(int idx=0;idx<4;idx++)
        {
            int newI=i+dx[idx];
            int newJ=j+dy[idx];

            if(newI>=0 && newI<board.length && newJ>=0 && newJ<board[0].length
                && board[newI][newJ]=='O' && visit[newI][newJ]==false)
                DFS(board,newI,newJ,visit);
        }
    }

    public void solve(char[][] board) {
        
        int row=board.length;
        int col=board[0].length;
        boolean [][]visit=new boolean[row][col];
        for(int i=0;i<row;i++)
        {
            if(visit[i][0]==false && board[i][0]=='O') 
                DFS(board,i,0,visit);
            if(visit[i][col-1]==false && board[i][col-1]=='O')
                DFS(board,i,col-1,visit);
        }

        for(int j=0;j<col;j++)
        {
            if(visit[0][j]==false && board[0][j]=='O')
                DFS(board,0,j,visit);
            if(visit[row-1][j]==false && board[row-1][j]=='O')
                DFS(board,row-1,j,visit);
        }

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(visit[i][j]==false && board[i][j]=='O')
                    board[i][j]='X';
            }
        }

        return ;
    }
}