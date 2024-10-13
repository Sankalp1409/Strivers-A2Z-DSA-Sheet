class Solution {
    
    class pair{
        int data,i,j;
        
        public pair(int data,int i, int j)
        {
            this.data=data;
            this.i=i;
            this.j=j;
        }
    }
    
    
    class comp implements Comparator<pair>{
        public int compare(pair p1, pair p2)
        {
            return p1.data-p2.data;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int ans=Integer.MAX_VALUE;
        int ansStart=0,ansEnd=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        PriorityQueue<pair>pq=new PriorityQueue<>(new comp());
        for(int i=0;i<nums.size();i++)
        {
            maxi=Math.max(nums.get(i).get(0),maxi);
            pq.add(new pair(nums.get(i).get(0),i,0));
        }
                   
        while(!pq.isEmpty())
       {
           pair top=pq.poll();
           mini=top.data;
           int i=top.i;
           int j=top.j;
           if(maxi-mini < ans)
           {
               ans=maxi-mini;
               ansStart=mini;
               ansEnd=maxi;
           }
           
           if(j+1<nums.get(i).size())
           {
               maxi=Math.max(maxi,nums.get(i).get(j+1));
               pq.add(new pair(nums.get(i).get(j+1),i,j+1));
           }
           else
               break;
       }
                   
           return new int []{ansStart,ansEnd}; 
    }
}