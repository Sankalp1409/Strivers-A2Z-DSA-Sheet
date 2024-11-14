class Solution {
    
    public boolean DFS(ArrayList<ArrayList<Integer>>adjList,int []color, 
                       int newColor, int node)
    {
        color[node]=newColor;
        for(int nei:adjList.get(node))
        {
            if(color[nei]==-1)
            {
                if(!DFS(adjList,color,(newColor+1)%2,nei))
                    return false;
            }
            else if(color[nei]==newColor)
                return false;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        
        int size=graph.length;
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<size;i++)
            adjList.add(new ArrayList<>());
        
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adjList.get(i).add(graph[i][j]);
            }
        }
        
        int []color=new int[size];
        Arrays.fill(color,-1);
        
        for(int i=0;i<size;i++)
        {
            if(color[i]==-1)
            {
                if(DFS(adjList,color,0,i)==false)
                    return false;
            }
        }
        return true;
    }
}