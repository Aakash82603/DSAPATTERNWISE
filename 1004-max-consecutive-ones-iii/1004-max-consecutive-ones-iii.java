class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int maxAns=0;
        int zerocount=0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]==0){
                zerocount++;
            }
            /*while*/ if(zerocount>k){
                if(nums[l]==0){
                    zerocount--;
                }
                 l++;
            }
           // maxAns=Math.max(maxAns,j-l+1)
           
           
        }
      //  return maxAns
        return nums.length-l;
        
    }
}