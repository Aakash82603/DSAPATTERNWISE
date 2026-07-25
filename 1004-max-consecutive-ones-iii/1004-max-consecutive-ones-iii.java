class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int maxAns=0;
        int zerocount=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]==0){
                zerocount++;
            }
            if(zerocount>k){
                if(nums[l]==0){
                    zerocount--;
                }
                 l++;
            }
           
           
        }
        return nums.length-l;
        
    }
}