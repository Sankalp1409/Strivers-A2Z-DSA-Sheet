class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayList<Integer>ans=new ArrayList<>();
        Deque<Integer>dq=new ArrayDeque<>();
        int i=0,j=0;
        
        while(j<nums.length)
        {
            while(!dq.isEmpty() && nums[j]>dq.getLast())
                    dq.removeLast();
            dq.addLast(nums[j]);
            if(j-i+1==k)
            {
                ans.add(dq.peek());
                if(dq.peek()==nums[i])
                    dq.removeFirst();
                i++;
            }
            j++;
        }
        
        int []arr=new int[ans.size()];
        for(int idx=0;idx<ans.size();idx++)
            arr[idx]=ans.get(idx);
        return arr;
    }
}