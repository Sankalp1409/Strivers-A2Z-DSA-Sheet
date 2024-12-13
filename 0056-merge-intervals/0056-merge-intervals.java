class Solution {
    
    class comp implements Comparator<int[]>{
        public int compare(int []a, int []b)
        {
            return a[0]-b[0];
        }
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new comp());
        Stack<int[]>st=new Stack<>();
        
        for(int i=0;i<intervals.length;i++)
        {
            if(!st.isEmpty() && intervals[i][0]<=st.peek()[1])
            {
                int []temp=st.pop();
                temp[0]=Math.min(temp[0],intervals[i][0]);
                temp[1]=Math.max(temp[1],intervals[i][1]);
                st.push(temp);
            }
            else
                st.push(intervals[i]);
        }
        
        int [][]ans=new int[st.size()][];
        int i=st.size()-1;
        while(!st.isEmpty())
            ans[i--]=st.pop();
        return ans;
    }
}