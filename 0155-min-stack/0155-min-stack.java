class MinStack {
    Stack<Integer>st;
    int mini;
    public MinStack() {
        st=new Stack<>();
        mini=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=mini)
        {
            st.push(mini);
            mini=val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.pop()==mini)
            mini=st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */