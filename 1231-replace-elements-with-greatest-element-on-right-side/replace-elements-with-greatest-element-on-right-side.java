class Solution {
    public int[] replaceElements(int[] arr) {
        int maxi=arr[arr.length-1];
        int ansArray[]=new int[arr.length];
        ansArray[arr.length-1]=-1;
        for(int i=arr.length-2;i>=0;i--)
        {
            ansArray[i]=maxi;
            maxi=Math.max(maxi,arr[i]);
        }
        return ansArray;
    }
}