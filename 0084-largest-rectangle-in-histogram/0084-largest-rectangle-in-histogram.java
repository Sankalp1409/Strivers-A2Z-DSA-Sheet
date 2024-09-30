class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n=heights.length;
        Stack<Integer>st=new Stack<>();
        int left[]=new int[n];
        int right[]=new int[n];
        
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            if(st.isEmpty())
                left[i]=-1;
            else
                left[i]=st.peek();
            st.push(i);
        }
        
        while(!st.isEmpty())
            st.pop();
        
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
                st.pop();
            
            if(st.isEmpty())
                right[i]=n;
            else
                right[i]=st.peek();
            st.push(i);
        }
        
        int ans=0;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        return ans;
    }
}