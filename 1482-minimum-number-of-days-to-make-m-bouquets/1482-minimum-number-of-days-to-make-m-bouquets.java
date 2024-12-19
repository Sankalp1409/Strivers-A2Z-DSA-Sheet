class Solution {
    
    public boolean isPossible(int []bloomDay, int m, int k, int mid)
    {
        int bouquets=0;
        int count=k;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=mid)
            {
                count--;
                if(count==0)
                {
                    bouquets++;
                    count=k;
                }
            }
            else
                count=k;
        }
        return bouquets>=m;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        
         if(((long)m*(long)k) > (long)bloomDay.length)
            return -1;
        int low=1;
        int high=0;
        for(int i:bloomDay)
            high=Math.max(i,high);
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(isPossible(bloomDay,m,k,mid))
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}