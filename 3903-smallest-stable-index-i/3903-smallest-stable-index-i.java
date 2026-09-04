class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int []prefixmax=new int[nums.length];
        int []suffixmin=new int[nums.length];
        prefixmax[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            prefixmax[i]=Math.max(prefixmax[i-1],nums[i]);
        }
        suffixmin[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            suffixmin[i]=Math.min(suffixmin[i+1],nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            if(prefixmax[i]-suffixmin[i]<=k){
                return i;
            }
        }
        return -1;
        
        
    }
}