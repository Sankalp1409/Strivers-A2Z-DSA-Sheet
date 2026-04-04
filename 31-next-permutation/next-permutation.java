class Solution {
    public void nextPermutation(int[] nums) {
        
        int idx1=-1;
        int idx2=-1;
        
        for(int i=nums.length-1;i>0;i--)
        {
            if(nums[i]>nums[i-1])
            {
                idx1=i-1;
                break;
            }
        }

        if(idx1==-1)
        {
            // reverse array
            reverseArray(nums);
            return ;
        }

        int value=nums[idx1];
        idx2=idx1+1;
        int nextGreaterValue=nums[idx2];
        for(int i=idx2;i<nums.length;i++)
        {
            if(nums[i]>value && nums[i]<=nextGreaterValue)
            {
                nextGreaterValue=nums[i];
                idx2=i;
            }
        }

        System.out.println("idx2 : "+idx2);
        swapValue(nums,idx1,idx2);

        Arrays.sort(nums,idx1+1,nums.length);
        return;
    }

    public void swapValue(int[] nums, int idx1, int idx2)
    {
        int temp=nums[idx1];
        nums[idx1]=nums[idx2];
        nums[idx2]=temp;
    }

    public void reverseArray(int []nums)
    {
        int left=0;
        int right=nums.length-1;

        while(left<right)
        {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}