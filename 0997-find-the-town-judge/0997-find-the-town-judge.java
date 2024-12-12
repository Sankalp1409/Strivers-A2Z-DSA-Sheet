class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if(trust.length==0)
        {
            if(n==1)
                return n;
            return -1;
        }
        int []indegree=new int[n+1];
        
        for(int i=0;i<trust.length;i++)
        {
            int u=trust[i][0];
            int v=trust[i][1];
            indegree[u]--;
            indegree[v]++;
        }
        
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==n-1)
                return i;
        }
        return -1;
    }
}