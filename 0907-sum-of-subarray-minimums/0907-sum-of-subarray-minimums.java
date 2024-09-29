class Solution {
    int mod=(int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        
        int n=arr.length;
        int []previous=new int[n];
        int []next=new int[n];
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            
            if(st.isEmpty())
                previous[i]=-1;
            else
                previous[i]=st.peek();
            
            st.push(i);
        }
        
        while(!st.isEmpty())
            st.pop();
        
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
                st.pop();
            
            if(st.isEmpty())
                next[i]=n;
            else
                next[i]=st.peek();
            st.push(i);
        }
        
        long ans=0;
        for(int i=0;i<n;i++)
        {
            int l=i-previous[i];
            int r=next[i]-i;
            long pro=(l*r)%mod;
            pro=(pro*arr[i])%mod;
            ans=(ans+pro)%mod;
        }
        return (int)ans;
    }
}