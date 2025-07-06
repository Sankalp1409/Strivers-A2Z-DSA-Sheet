class Solution {

    class comp implements Comparator<int[]>
    {
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
            //stack is empty
            if(st.isEmpty())
            {
                st.push(intervals[i]);
            }
            else
            {
                // overlapping condition
                if(intervals[i][0]<=st.peek()[1])
                {
                    int topInterval[]=new int[2];
                    topInterval[0]=Math.min(st.peek()[0],intervals[i][0]);
                    topInterval[1]=Math.max(st.peek()[1],intervals[i][1]);
                    st.pop();
                    st.push(topInterval);
                }
                // non-overlapping
                else
                {
                    st.push(intervals[i]);
                }
            }
        } 

        int [][]ansArray=new int[st.size()][2];
        for(int i=ansArray.length-1;i>=0;i--)
        {
            ansArray[i]=st.pop();
        }   
        return ansArray;
    }
}