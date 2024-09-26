class Solution {
    public boolean isPlaced(char [][]board, int x,int y, char value)
    {
        // row check
        for(int j=0;j<9;j++)
        {
            if(board[x][j]==value || board[j][y]==value)
                return false;
            if(board[3*(x/3)+j/3][3*(y/3)+j%3]==value)
                return false;
        }
        return true;
    }
    public boolean solve(char [][]board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    for(int val=1;val<=9;val++)
                    {
                        if(isPlaced(board,i,j,(char)(val+48)))
                        {
                            board[i][j]=(char)(val+48);
                            if(solve(board))
                                return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        
        solve(board);
    }
}