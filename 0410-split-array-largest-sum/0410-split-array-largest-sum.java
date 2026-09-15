class Solution {
    public int solve(int[]nums,int mid){
        int count=1;
        int store=0;
        for(int i=0; i<nums.length; i++){
            if(store+nums[i]<=mid){
                store+=nums[i];
            }else{
                count++;
                store=nums[i];
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int max=0;
        int sum=0;
        for(int num:nums){
            max=Math.max(max,num);
            sum+=num;
        }
        int left=max;
        int right=sum;
        while(left<=right){
            int mid=left+(right-left)/2;
            int ans=solve(nums,mid);
            if(ans>k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
        
    }
}