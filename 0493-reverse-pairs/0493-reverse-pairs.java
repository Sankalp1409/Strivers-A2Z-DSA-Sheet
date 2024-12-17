class Solution {
    
    int solve(int []a, int b[])
    {
        int i=0,j=0;
        int count=0;
        
        while(i<a.length && j<b.length)
        {
            if(a[i] > 2*(long)(b[j]))
                j++;
            else
            {
                count+=j;
                i++;
            }
        }
        while(i<a.length)
        {
            count+=j;
            i++;
        }
        return count;
    }
    
    public int merge(int []arr,int low, int mid, int high)
    {
        int len1=mid-low+1;
        int len2=high-mid;
        
        int []a=new int[len1];
        int []b=new int[len2];
        
        for(int i=0;i<a.length;i++)
            a[i]=arr[i+low];
        for(int i=0;i<b.length;i++)
            b[i]=arr[mid+i+1];
        
        int count=solve(a,b);
        int k=low;
        int i=0,j=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]<b[j])
                arr[k++]=a[i++];
            else
                arr[k++]=b[j++];
        }
        
        while(i<a.length)
            arr[k++]=a[i++];
    
        while(j<b.length)
            arr[k++]=b[j++];
        
        return count;
        
    }
    
    public int mergeSort(int []nums, int low,int high)
    {
        if(low>=high) return 0;
        
        int mid=low+(high-low)/2;
        
        int left=mergeSort(nums,low,mid);
        int right=mergeSort(nums,mid+1,high);
        
        return left+right+merge(nums,low,mid,high);
    }
    
    public int reversePairs(int[] nums) {
        
        return mergeSort(nums,0,nums.length-1);
        
    }
}