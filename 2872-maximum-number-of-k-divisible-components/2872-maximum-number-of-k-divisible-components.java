class Solution {
    
    public long solve(ArrayList<ArrayList<Integer>>adjList, int []values,
                    int parent,int k, int []count, int src)
    {
        long sum=values[src];
        for(int nei:adjList.get(src))
        {
            if(nei!=parent)
            {
                sum+=solve(adjList,values,src,k,count,nei);
            }
        }
        
        if(sum%k==0)
        {
            count[0]++;
            return 0;
        }
        return sum;
    }
    
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        int []count=new int[1];
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        solve(adjList,values,-1,k,count,0);
        return count[0];
    }
}