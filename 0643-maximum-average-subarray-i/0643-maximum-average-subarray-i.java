class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        int sum=0;
        double average=0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        int maxsum=sum;
        for(int right=k; right<nums.length; right++){
            sum-=nums[left];
            sum+=nums[right];
            left++;
             maxsum = Math.max(maxsum, sum);
        }
        return (double) maxsum / k;
        
    }
}