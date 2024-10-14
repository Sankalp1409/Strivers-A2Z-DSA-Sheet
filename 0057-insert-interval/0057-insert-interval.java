class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         
        List<int []>list=new ArrayList<>();
        int i=0;
        while(i<intervals.length && intervals[i][1] < newInterval[0])
        {
            list.add(intervals[i]);
            i++;
        }
        
        int []temp=new int[]{newInterval[0],newInterval[1]};
        while(i<intervals.length && newInterval[1]>=intervals[i][0])
        {
            temp[0]=Math.min(temp[0],intervals[i][0]);
            temp[1]=Math.max(temp[1],intervals[i][1]);
            i++;
        }
        list.add(temp);
        
        while(i<intervals.length)
        {
            list.add(intervals[i]);
            i++;
        }
        int [][]ans=new int[list.size()][2];
        for(int idx=0;idx<ans.length;idx++)
            ans[idx]=list.get(idx);
        return ans;
    }
}