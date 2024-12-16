class Solution {
    
    class pair{
        int data,index;
        
        public pair(int data, int index)
        {
            this.data=data;
            this.index=index;
        }
    }
    
    class comp implements Comparator<pair>{
        public int compare(pair p1, pair p2)
        {
            if(p1.data==p2.data)
                return p1.index-p2.index;
            return p1.data-p2.data;
        }
    }
    
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        PriorityQueue<pair>pq=new PriorityQueue<>(new comp());
        for(int i=0;i<nums.length;i++)
            pq.add(new pair(nums[i],i));
        
        for(int i=0;i<k;i++)
        {
            pair top=pq.poll();
            pq.add(new pair(top.data*multiplier,top.index));
        }
        
        int []ansArray=new int[nums.length];
        while(!pq.isEmpty())
        {
            pair top=pq.poll();
            ansArray[top.index]=top.data;
        }
        return ansArray;
    }
}