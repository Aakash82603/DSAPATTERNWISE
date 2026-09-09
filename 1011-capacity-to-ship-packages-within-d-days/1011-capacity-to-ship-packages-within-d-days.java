class Solution {
    int noOfDays(int[] weights, int days,int mid){
        days=1;
        int load=0;
        for(int i=0; i<weights.length; i++){
            
            if(load + weights[i] > mid){
                days++;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int totalsum=0;
        int max=Integer.MIN_VALUE;
        for(int num:weights){
            totalsum+=num;
            max=Math.max(max,num);
        }
        int left=max;
        int right=totalsum;
        while(left<=right){
            int mid=left+(right-left)/2;
            int ans=noOfDays(weights,days,mid);
            if(ans<=days){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
        
    }
}