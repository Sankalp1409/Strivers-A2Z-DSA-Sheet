class Solution {
    
    public void DFS(int [][]image,int x, int y, int color, 
                    int startColor,boolean [][]visit)
    {
        visit[x][y]=true;
        image[x][y]=color;
        
        int dx[]={1,0,-1,0};
        int dy[]={0,-1,0,1};
        
        for(int i=0;i<4;i++)
        {
            int newx=x+dx[i];
            int newy=y+dy[i];
            if(newx>=0 && newx<image.length && newy>=0 && newy<image[0].length 
              && visit[newx][newy]==false && image[newx][newy]==startColor)
                DFS(image,newx,newy,color,startColor,visit);
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row=image.length;
        int col=image[0].length;
        int startColor=image[sr][sc];
        boolean [][]visit=new boolean[row][col];
        DFS(image,sr,sc,color,startColor,visit);
        return image;
    }
}