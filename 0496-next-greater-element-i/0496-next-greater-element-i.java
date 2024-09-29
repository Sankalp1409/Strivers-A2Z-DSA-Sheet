class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums2.length;i++)
            mp.put(nums2[i],i);
        
        int []ans=new int[nums1.length];
        int []arr=new int[nums2.length];
        Stack<Integer>st=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums2[i])
                st.pop();
            
            if(st.isEmpty())
                arr[i]=-1;
            else
                arr[i]=st.peek();
            st.push(nums2[i]);
        }
        for(int i:arr)
            System.out.print(i+" ");
        for(int i=0;i<nums1.length;i++)
            ans[i]=arr[mp.get(nums1[i])];
        return ans;
        
    }
}