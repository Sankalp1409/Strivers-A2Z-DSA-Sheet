class Solution {
    
    class pair{
        int data,freq;
        
        public pair(int data, int freq)
        {
            this.data=data;
            this.freq=freq;
        }
    }
    
    class comp implements Comparator<pair>{
        public int compare(pair p1, pair p2)
        {
            return p1.freq-p2.freq;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        
        PriorityQueue<pair>pq=new PriorityQueue<>(new comp());
        for(Map.Entry<Integer,Integer>e:mp.entrySet())
        {
            if(pq.size()<k)
                pq.add(new pair(e.getKey(),e.getValue()));
            else if(pq.size()==k)
            {
                if(e.getValue()>=pq.peek().freq)
                {
                    pq.poll();
                    pq.add(new pair(e.getKey(),e.getValue()));
                }
            }
        }
        
        int index=0;
        int []ansArray=new int[k];
        while(!pq.isEmpty())
            ansArray[index++]=pq.poll().data;
        return ansArray;
    }
}