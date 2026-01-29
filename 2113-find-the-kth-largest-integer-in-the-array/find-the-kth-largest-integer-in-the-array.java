class Solution {

    class comp implements Comparator<String>
    {
        public int compare(String a, String b)
        {
            if(a.length()!=b.length())
                return a.length()-b.length();
            return a.compareTo(b);
        }
    }

    public int compareString(String a, String b)
    {
        if(a.length()!=b.length())
            return a.length()-b.length();
        return a.compareTo(b);
    }
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String>pq=new PriorityQueue<>(new comp());

        for(int i=0;i<nums.length;i++)
        {
            if(pq.size()<k)
                pq.add(nums[i]);
            else
            {
                if(compareString(nums[i],pq.peek())>0)
                {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
            System.out.println(pq.peek());
        }
        return pq.peek();
    }
}