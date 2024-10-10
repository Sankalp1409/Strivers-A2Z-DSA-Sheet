class MedianFinder {
    PriorityQueue<Integer>minHeap;
    PriorityQueue<Integer>maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        
        // inserted in maxHeap
        if(maxHeap.isEmpty() || num<maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        balanceHeap();        
    }
    
    public void balanceHeap()
    {
        if(maxHeap.size()-minHeap.size()>1)
            minHeap.add(maxHeap.poll());
        else if(minHeap.size()-maxHeap.size()>1)
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        
        if(minHeap.size()==maxHeap.size())
            return (minHeap.peek()+maxHeap.peek())/2.0;
        else if(minHeap.size()> maxHeap.size())
            return (double)(minHeap.peek());
        else
            return (double)(maxHeap.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */