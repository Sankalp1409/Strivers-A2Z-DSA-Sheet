class Solution {
    
    public int countSubarray(int []nums, int k)
    {
        int count=0;
        int countOdd=0;
        int i=0,j=0;
        
        while(j<nums.length)
        {
            if(nums[j]%2!=0)
                countOdd++;
            
            while(countOdd>k)
            {
                if(nums[i]%2!=0)
                    countOdd--;
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    
    public int numberOfSubarrays(int[] nums, int k) {
        return countSubarray(nums,k)-countSubarray(nums,k-1);
    }
}