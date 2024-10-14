class Solution {
    
    class comp implements Comparator<int[]>{
        public int compare(int []a, int []b)
        {
            return a[0]-b[0];
        }
    }
    
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,new comp());
        int n=intervals.length;
        Stack<int[]>st=new Stack<>();
        st.push(intervals[0]);
        for(int i=1;i<n;i++)
        {
            if(!st.isEmpty() && st.peek()[1]>=intervals[i][0])
            {
                int []top=st.pop();
                top[0]=Math.min(top[0],intervals[i][0]);
                top[1]=Math.max(top[1],intervals[i][1]);
                st.push(top);
            }
            else
                st.push(intervals[i]);
        }
        
        int index=0;
        int [][]ans=new int[st.size()][2];
        while(!st.isEmpty())
            ans[index++]=st.pop();
        return ans;
    }
}