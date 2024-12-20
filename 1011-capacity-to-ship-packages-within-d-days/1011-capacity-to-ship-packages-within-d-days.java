class Solution {
    
    public boolean isPossible(int []weights,int days, int mid)
    {
        int count=1;
        int sum=0;
        for(int i=0;i<weights.length;i++)
        {
            if(weights[i]>mid) return false;
            if(sum+weights[i]<=mid)
                sum+=weights[i];
            else
            {
                count++;
                sum=weights[i];
            }
        }
        return count<=days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        
        int low=1;
        int high=0;
        for(int i:weights)
            high+=i;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(isPossible(weights,days,mid))
                high=mid-1;
            else
                low=mid+1;
        }
        return low; 
    }
}