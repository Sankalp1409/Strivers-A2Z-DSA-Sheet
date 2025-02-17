class Solution {

    public void DFS(int [][]grid,int i, int j , boolean [][]visit)
    {
        visit[i][j]=true;

        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};

        for(int idx=0;idx<4;idx++)
        {
            int newI=i+dx[idx];
            int newJ=j+dy[idx];

            if(newI>=0 && newI<grid.length && newJ>=0 && newJ<grid[0].length
                && grid[newI][newJ]==1 && visit[newI][newJ]==false)
                DFS(grid,newI,newJ,visit);
        }
    }

    public int numEnclaves(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        boolean [][]visit=new boolean[row][col];
        for(int i=0;i<row;i++)
        {
            if(visit[i][0]==false && grid[i][0]==1) 
                DFS(grid,i,0,visit);
            if(visit[i][col-1]==false && grid[i][col-1]==1)
                DFS(grid,i,col-1,visit);
        }

        for(int j=0;j<col;j++)
        {
            if(visit[0][j]==false && grid[0][j]==1)
                DFS(grid,0,j,visit);
            if(visit[row-1][j]==false && grid[row-1][j]==1)
                DFS(grid,row-1,j,visit);
        }

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(visit[i][j]==false && grid[i][j]==1)
                    count++;
            }
        }

        return count;
    }
}