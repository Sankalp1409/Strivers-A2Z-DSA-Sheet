class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]>finalInterval=new ArrayList<>();
        int i=0;
        while(i<intervals.length &&intervals[i][1]<newInterval[0])
        {
            finalInterval.add(intervals[i]);
            i++;
        }
        int insertInterval[]=new int[2];
        insertInterval[0]=newInterval[0];
        insertInterval[1]=newInterval[1];
        while(i<intervals.length && intervals[i][0]<=newInterval[1])
        {
            insertInterval[0]=Math.min(insertInterval[0],intervals[i][0]);
            insertInterval[1]=Math.max(insertInterval[1],intervals[i][1]);
            i++;
        }
        finalInterval.add(insertInterval);
        while(i<intervals.length)
        {
            finalInterval.add(intervals[i]);
            i++;
        }
        int [][]finalIntervalArray=new int[finalInterval.size()][2];
        for(int idx=0;idx<finalIntervalArray.length;idx++)
        {
            finalIntervalArray[idx]=finalInterval.get(idx);
        }
        return finalIntervalArray;
    }
}