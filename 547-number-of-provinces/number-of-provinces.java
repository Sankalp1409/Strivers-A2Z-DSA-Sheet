class Solution {

    public void DFS(List<List<Integer>>adjList,boolean []visit, int src)
    {
        visit[src]=true;

        for(int nei:adjList.get(src))
        {
            if(visit[nei]==false)
                DFS(adjList,visit,nei);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>>adjList=new ArrayList<>();
        boolean []visit=new boolean[n];
        int provinces=0;

        for(int i=0;i<isConnected.length;i++)
            adjList.add(new ArrayList<Integer>());
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(i!=j && isConnected[i][j]==1)
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        for(int i=0;i<isConnected.length;i++)
        {
            if(visit[i]==false)
            {
                provinces++;
                DFS(adjList,visit,i);
            }
        }
        return provinces;
    }
}