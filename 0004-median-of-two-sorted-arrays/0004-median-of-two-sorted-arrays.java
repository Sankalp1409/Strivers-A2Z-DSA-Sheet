class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        
        int len=nums1.length+nums2.length;
        int low=0;
        int high=Math.min(nums1.length,len/2);
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int cut1=mid;
            int cut2=len/2-cut1;
            
            int l1= cut1==0 ? Integer.MIN_VALUE:nums1[cut1-1];
            int l2= cut2==0 ? Integer.MIN_VALUE:nums2[cut2-1];
            
            int r1=cut1==nums1.length ? Integer.MAX_VALUE:nums1[cut1];
            int r2=cut2==nums2.length ? Integer.MAX_VALUE:nums2[cut2];
            
            if(l1<=r2 && l2<=r1)
            {
                if(len%2!=0)
                    return Math.min(r1,r2);
                else
                    return ((double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0);
            }
            else if(l1>r2)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}