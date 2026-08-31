class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minindex=nums[0];
        int maxindex=nums[0];
        int minresult=nums[0];
        int maxresult=nums[0];
        int totalSum=nums[0];
        for(int i=1; i<nums.length; i++){
            totalSum+=nums[i];
           maxindex=Math.max(nums[i],nums[i]+maxindex);
           maxresult=Math.max(maxresult,maxindex);
           minindex=Math.min(nums[i],nums[i]+minindex);
           minresult=Math.min(minindex,minresult);
        }
        if(maxresult<0){
            return maxresult;
        }else{
            int circularsum=totalSum-minresult;
            maxresult=Math.max(maxresult,circularsum);
        }
        return maxresult;
    }
}