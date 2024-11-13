class Solution {
    class custom{
        int i,j,dis;
        public custom(int i, int j, int dis)
        {
            this.i=i;
            this.j=j;
            this.dis=dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int [][]ans=new int[mat.length][mat[0].length];
        Queue<custom>q=new LinkedList<>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==0)
                    q.add(new custom(i,j,0));
                else
                    ans[i][j]=(int)(1e8);
            }
        }
        while(!q.isEmpty())
        {
            custom front=q.poll();
            int dx[]={1,0,-1,0};
            int dy[]={0,-1,0,1};
            
            for(int idx=0;idx<4;idx++)
            {
                int newx=front.i+dx[idx];
                int newy=front.j+dy[idx];
                if(newx>=0 && newx<mat.length && newy>=0 && newy<mat[0].length && 
                   mat[newx][newy]==1 && front.dis+1 < ans[newx][newy])
                {
                    ans[newx][newy]=front.dis+1;
                    q.add(new custom(newx,newy,ans[newx][newy]));
                }
            }
        }
        return ans;
        
    }
}