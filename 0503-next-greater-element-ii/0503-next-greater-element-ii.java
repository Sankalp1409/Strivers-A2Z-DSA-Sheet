class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int len=nums.length;
        int []ans=new int[nums.length];
        Stack<Integer>st=new Stack<>();
        
        for(int i=2*len-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums[i%len])
                st.pop();
            
            if(st.isEmpty())
                ans[i%len]=-1;
            else
                ans[i%len]=st.peek();
            st.push(nums[i%len]);
        }
        return ans;
        
    }
}