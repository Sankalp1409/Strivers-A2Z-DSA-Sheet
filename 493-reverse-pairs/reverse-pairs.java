class Solution {

    public int findInCurrentIteation(int []nums, int left, int mid, int right)
    {
        int len1=mid-left+1;
        int len2=right-mid;
        int a[]=new int[len1];
        int b[]=new int[len2];
        int count=0;

        for(int i=0;i<a.length;i++)
            a[i]=nums[left+i];

        for(int i=0;i<b.length;i++)
            b[i]=nums[mid+i+1];
        
        int i=0,j=0,k=left;
        while(i<len1 && j<len2)
        {
            if((long)a[i]>(2L*b[j]))
                j++;
            else
            {
                count+=j;
                i++;
            }
        }
        if(i<len1)
            count=count+((len1-i)*j);
        i=0;
        j=0;

        while(i<len1 && j<len2)
        {
            if(a[i]>b[j])
                nums[k++]=b[j++];
            else
                nums[k++]=a[i++];
        }

        while(i<len1)
            nums[k++]=a[i++];
        while(j<len2)
            nums[k++]=b[j++];

        return count;
    }
    public int findReversePair(int []nums,int left, int right)
    {
        if(left>=right)
            return 0;
        
        int mid=left+(right-left)/2;
        int leftIterationPair=findReversePair(nums,left,mid);
        int rightIterationPair=findReversePair(nums,mid+1,right);
        int countPiarCurrentIteration=findInCurrentIteation(nums,left,mid,right);
        return leftIterationPair+rightIterationPair+countPiarCurrentIteration;
    }

    public int reversePairs(int[] nums) {
        
        return findReversePair(nums,0,nums.length-1);

    }
}