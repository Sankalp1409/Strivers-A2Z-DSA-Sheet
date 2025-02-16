class Solution {

    public void DFS(int [][]image,boolean [][]visit, int x, int y, int startColor, int color)
    {
        visit[x][y]=true;
        image[x][y]=color;

        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};

        for(int idx=0;idx<4;idx++)
        {
            int newX=x+dx[idx];
            int newY=y+dy[idx];

            if(newX>=0 && newX<image.length && newY>=0 && newY<image[0].length
                && image[newX][newY]==startColor && visit[newX][newY]==false)
                {
                    DFS(image,visit,newX,newY,startColor,color);
                }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor=image[sr][sc];
        boolean [][]visit=new boolean[image.length][image[0].length];
        DFS(image,visit,sr,sc,startColor,color);
        return image;
    }
}