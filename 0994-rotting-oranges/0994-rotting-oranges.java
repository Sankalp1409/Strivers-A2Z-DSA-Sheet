class Solution {
    
    class pair{
        int i,j;
        
        public pair(int i, int j)
        {
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int totalOrange=0;
        int row=grid.length;
        int col=grid[0].length;
        boolean [][]visit=new boolean[row][col];
        Queue<pair>q=new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]!=0)
                {
                    totalOrange++;
                    if(grid[i][j]==2)
                        q.add(new pair(i,j));
                }
            }
        }
        int time=0;
        int rottenOrange=0;
        while(!q.isEmpty())
        {
            rottenOrange+=q.size();
            int size=q.size();
            int dx[]={1,0,-1,0};
            int dy[]={0,-1,0,1};
            for(int i=0;i<size;i++)
            {
                pair p=q.poll();
                int x=p.i;
                int y=p.j;
                
                for(int idx=0;idx<4;idx++)
                {
                    int newx=x+dx[idx];
                    int newy=y+dy[idx];
                    
                    if(newx>=0 && newx<row && newy>=0 && newy<col && 
                        visit[newx][newy]==false && grid[newx][newy]==1)
                    {
                        q.add(new pair(newx,newy));
                        visit[newx][newy]=true;
                    }
                }
            }
            if(q.size()>0)
                time++;
        }
        System.out.println(rottenOrange+" "+totalOrange);
        if(rottenOrange!=totalOrange) return -1;
        return time;
    }
}