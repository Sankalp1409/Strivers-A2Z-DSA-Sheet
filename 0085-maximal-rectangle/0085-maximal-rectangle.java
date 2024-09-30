class Solution {
    
    public int largestAreaOfHistogram(int []num, int n)
    {
        int []left=new int[n];
        int []right=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && num[st.peek()]>=num[i])
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
            while(!st.isEmpty() && num[st.peek()]>=num[i])
                st.pop();
            
            if(st.isEmpty())
                right[i]=n;
            else
                right[i]=st.peek();
            st.push(i);
        }
        
        int ans=0;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,(right[i]-left[i]-1)*num[i]);
        return ans;
    }
    
    public int maximalRectangle(char[][] matrix) {
        
        int row=matrix.length;
        int col=matrix[0].length;
        
        int ans=0;
        int []base=new int[col];
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j]=='0')
                    base[j]=0;
                else
                    base[j]+=1;
            }
            ans=Math.max(ans,largestAreaOfHistogram(base,col));
        }
        
        return ans;
    }
}