class Solution {
    
    public boolean isPossible(int []piles, int h, int mid)
    {
        int hours=0;
        for(int i=0;i<piles.length;i++)
        {
            hours+=piles[i]/mid;
            if(piles[i]%mid!=0)
                hours++;
            if(hours>h) return false;
        }
        return true;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        
        int low=1;
        int high=0;
        for(int i:piles)
            high=Math.max(i,high);
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(isPossible(piles,h,mid))
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}