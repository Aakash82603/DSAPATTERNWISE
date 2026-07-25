class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentcount=0;
        int max=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                currentcount+=nums[i];
                if(currentcount>max){
                    max=currentcount;
                }
            }else{
                currentcount=0;
            }
        }
        return max;
    }
}