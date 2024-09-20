class BrowserHistory {

    class Node{
        String url;
        Node next;
        Node prev;
        public Node(String url)
        {
            this.url=url;
            this.next=null;
            this.prev=null;
        }
    }
    
    Node head=null;
    Node ptr;
    public BrowserHistory(String homepage) {
        Node p=new Node(homepage);
        head=p;
        ptr=p;
    }
    
    public void visit(String url) {
        
        Node p=new Node(url);
        ptr.next=p;
        p.prev=ptr;
        ptr=ptr.next;
    }
    
    public String back(int steps) {
        
        while(steps>0 && ptr.prev!=null)
        {
            steps--;
            ptr=ptr.prev;
        }
        return ptr.url;
    }
    
    public String forward(int steps) {
        
        while(steps>0 && ptr.next!=null)
        {
            steps--;
            ptr=ptr.next;
        }
        return ptr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */