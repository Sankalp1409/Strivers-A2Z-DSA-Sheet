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
        int row=mat.length;
        int col=mat[0].length;
        boolean [][]visit=new boolean[row][col];
        int [][]disMatrix=new int[row][col];
        Queue<custom>q=new LinkedList<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new custom(i,j,0));
                    visit[i][j]=true;
                }
            }
        }


        while(!q.isEmpty())
        {
            custom front=q.poll();
            int i=front.i;
            int j=front.j;
            int dis=front.dis;
            disMatrix[i][j]=dis;

            int dx[]={0,1,0,-1};
            int dy[]={1,0,-1,0};

            for(int idx=0;idx<4;idx++)
            {
                int newI=i+dx[idx];
                int newJ=j+dy[idx];

                if(newI>=0 && newI<row && newJ>=0 && newJ<col && 
                    visit[newI][newJ]==false && mat[newI][newJ]==1)
                {
                    q.add(new custom(newI,newJ,dis+1));
                    visit[newI][newJ]=true;
                }
            }
        }

        return disMatrix;    
    }
}