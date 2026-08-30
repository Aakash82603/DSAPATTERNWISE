class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
     int minindex=0;
     int maxindex=nums.length-1;
     for(int i=0; i<nums.length; i++){
        if(nums[i]<min){
            min=nums[i];
            minindex=i;
        }
        if(nums[i]>max){
            max=nums[i];
            maxindex=i;
        }
     }
     int left=Math.min(minindex,maxindex);
     int right=Math.max(minindex,maxindex);
     int front = right+1;
     int back=nums.length-left;
     int mix=(left+1)+(nums.length-right);
     return Math.min(front,Math.min(back,mix));
        
    }
}