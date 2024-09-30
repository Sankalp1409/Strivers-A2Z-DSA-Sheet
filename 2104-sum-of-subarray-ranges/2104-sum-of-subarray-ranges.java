class Solution {
    
    public long findMinimumContribution(int []nums)
    {
        int []left=new int[nums.length];
        int []right=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]>=nums[i])
                st.pop();
            
            if(st.isEmpty())
                left[i]=-1;
            else
                left[i]=st.peek();
            st.push(i);
        }
        
        while(!st.isEmpty())
            st.pop();
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
                st.pop();
            if(st.isEmpty())
                right[i]=nums.length;
            else
                right[i]=st.peek();
            st.push(i);
        }
        
        long ans=0;
        for(int i=0;i<nums.length;i++)
        {
            int l=i-left[i];
            int r=right[i]-i;
            long pro=(l*r);
            pro=(pro*nums[i]);
            ans=(ans+pro);
        }
        
        return ans;
    }
    
    public long findMaximumContribution(int []nums)
    {
        int []left=new int[nums.length];
        int []right=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]<=nums[i])
                st.pop();
            
            if(st.isEmpty())
                left[i]=-1;
            else
                left[i]=st.peek();
            st.push(i);
        }
        
        while(!st.isEmpty())
            st.pop();
        for(int i=nums.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()]<nums[i])
                st.pop();
            if(st.isEmpty())
                right[i]=nums.length;
            else
                right[i]=st.peek();
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<nums.length;i++)
        {
            int l=i-left[i];
            int r=right[i]-i;
            long pro=(l*r);
            pro=(pro*nums[i]);
            ans=(ans+pro);
        }
        
        return ans;
    }
    
    public long subArrayRanges(int[] nums) {
        
        return findMaximumContribution(nums)-findMinimumContribution(nums);
        
        
    }
}