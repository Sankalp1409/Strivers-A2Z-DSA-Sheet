class pair{
    int data;
    int index;
    
    public pair(int data, int index)
    {
        this.data=data;
        this.index=index;
    }
}

class StockSpanner {
    Stack<pair>st;
    int i;
    public StockSpanner() {
        st=new Stack<>();
        i=0;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek().data<=price)
            st.pop();
        
        int ans=0;
        if(st.isEmpty())
            ans= i+1;
        else
            ans=i-st.peek().index;
        st.push(new pair(price,i));
        i++;
        return ans;
            
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */