class Solution {
    
    public void DFS(ArrayList<ArrayList<Integer>>adjList,boolean []visit, int node)
    {
        visit[node]=true;
        
        for(int nei:adjList.get(node))
        {
            if(visit[nei]==false)
                DFS(adjList,visit,nei);
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1)
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        boolean []visit=new boolean[n];
        int province=0;
        for(int i=0;i<n;i++)
        {
            if(visit[i]==false)
            {
                DFS(adjList,visit,i);
                province++;
            }
        }
        return province;
    }
}