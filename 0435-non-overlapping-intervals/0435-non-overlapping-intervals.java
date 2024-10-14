class Solution {
    
    class comp implements Comparator<int[]>{
        public int compare(int []a, int []b)
        {
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        }
    }
    
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int remove=0;
        int prev=0,i=1;
        Arrays.sort(intervals,new comp());
        while(i<intervals.length)
        {
            // overlap
            if(intervals[prev][1]>intervals[i][0])
            {
                remove++;
                //complete overlap
                if(intervals[prev][1]>=intervals[i][1])
                    prev=i;
            }
            else
                prev=i;
            i++;
        }
        return remove;
    }
}