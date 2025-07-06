class Solution {

    public class comp implements Comparator<int[]>{
        public int compare(int []a ,int []b)
        {
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        
        // sort the array
        Arrays.sort(intervals,new comp());

        int removal=0;
        int previous=0;
        for(int curr=1;curr<intervals.length;curr++)
        {
            //overlapping
            if(intervals[curr][0]<intervals[previous][1])
            {
                removal++;
                // previous interval completely overlap
                if(intervals[curr][1]<intervals[previous][1])
                {
                    previous=curr;
                }
            }
            else
                previous=curr;
        }
        return removal;
    }
}