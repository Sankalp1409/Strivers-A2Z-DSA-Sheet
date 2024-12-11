class Solution {
    class pair{
        int start,end;
        
        public pair(int start, int end)
        {
            this.start=start;
            this.end=end;
        }
    }
    
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<pair>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            list.add(new pair(nums[i]-k,nums[i]+k));
        
        int result=0;
        Deque<Integer>dq=new ArrayDeque<>();
        for(int i=0;i<list.size();i++)
        {
            while(!dq.isEmpty() && dq.getFirst()<list.get(i).start)
                dq.pollFirst();
            dq.add(list.get(i).end);
            result=Math.max(result,dq.size());
        }
        return result;
        
    }
    
}