class Solution {
    public int maxArea(int[] height) {
        
        int len=height.length;
        int left=0;
        int right=len-1;
        int area=0;
        while(left<right)
        {
            area=Math.max(area,(right-left)*Math.min(height[left],height[right]));
            
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return area;
    }
}