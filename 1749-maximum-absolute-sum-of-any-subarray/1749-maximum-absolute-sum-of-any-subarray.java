class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minindex=nums[0];
        int maxindex=nums[0];
        int minresult=nums[0];
        int maxresult=nums[0];
        int finalresult=nums[0];
    
        for(int i=1; i<nums.length; i++){
            minindex=Math.min(nums[i],minindex+nums[i]);
            minresult=Math.min(minresult,minindex);
             maxindex=Math.max(nums[i],maxindex+nums[i]);
            maxresult=Math.max(maxresult,maxindex);
            finalresult=Math.max(Math.abs(minresult),Math.abs(maxresult));

        }
        return finalresult;
        
    }
}