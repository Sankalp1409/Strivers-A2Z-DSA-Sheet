class LRUCache {
    
    class Node{
        int key,value;
        Node next;
        Node prev;
        public Node(int key, int value)
        {
            this.key=key;
            this.value=value;
            next=null;
            prev=null;
        }
    }
    
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int size;
    Map<Integer,Node>mp;
    
    public LRUCache(int capacity) {
        mp=new HashMap<>();
        size=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        
        if(mp.containsKey(key))
        {
            Node ptr=mp.get(key);
            delete(ptr);
            add(new Node(ptr.key,ptr.value));
            return ptr.value;
        }
        else
            return -1;
        
    }
    
    public void put(int key, int value) {
        
        Node p=new Node(key,value);
        if(mp.containsKey(key))
            delete(mp.get(key));
        else if(mp.size()==size) 
            delete(tail.prev);
        add(p);
    }
    
    public void delete(Node ptr)
    {
        mp.remove(ptr.key);
        ptr.prev.next=ptr.next;
        ptr.next.prev=ptr.prev;
        ptr.next=null;
        ptr.prev=null;
    }
    
    public void add(Node ptr)
    {
        mp.put(ptr.key,ptr);
        ptr.prev=head;
        ptr.next=head.next;
        head.next=ptr;
        ptr.next.prev=ptr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */