class Solution {
    public long totalsum(int[] nums, int threshold, int mid){
        long sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=Math.ceil(nums[i]/(double)mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int left=1;
        int right=max;
        while(left<=right){
            int mid=left+(right-left)/2;
            long ans=totalsum(nums,threshold,mid);
            if(ans<=threshold){
                right=mid-1;
            
            }else{
                left=mid+1;
            }
        }
        return left;
        
    }
}