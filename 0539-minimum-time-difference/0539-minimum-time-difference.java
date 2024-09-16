class Solution {
    public int findMinDifference(List<String> timePoints) {
     
        ArrayList<Integer>list=new ArrayList<>();
        
        for(int i=0;i<timePoints.size();i++)
        {
            int time=0;
            String []arr=timePoints.get(i).split(":");
            
            time=Integer.parseInt(arr[0])*60;
            time+=Integer.parseInt(arr[1]);
            list.add(time);
        }
        
        Collections.sort(list);
        int miniTime=Integer.MAX_VALUE;
        
        for(int i=1;i<list.size();i++)
            miniTime=Math.min(miniTime,list.get(i)-list.get(i-1));
        
        miniTime=Math.min(miniTime,1440+list.get(0)-list.get(list.size()-1));
        
        return miniTime;
    }
}