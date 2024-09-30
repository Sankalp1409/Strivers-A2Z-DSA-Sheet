class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i]>0)
                st.push(asteroids[i]);
            else
            {
                while(!st.isEmpty() && st.peek()>=0 && Math.abs(asteroids[i])>st.peek())
                    st.pop();
                
                if(!st.isEmpty()&& st.peek()>=0 && Math.abs(asteroids[i])==st.peek())
                    st.pop();
                else if(!st.isEmpty()&& st.peek()>=0 && Math.abs(asteroids[i])<st.peek())
                {
                    
                }
                else
                    st.push(asteroids[i]);
            }
        }
        
        int []ans=new int[st.size()];
        int idx=st.size()-1;
        while(!st.isEmpty())
            ans[idx--]=st.pop();
        return ans;
    }
}