class Solution {
    public int solve(int[] bloomDay, int m, int k,int day){
        int count=0;
        int noOfBucket=0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i]<=day){
                count++;
            }else{
                noOfBucket+=count/k;
                count=0;
            }
        }
       noOfBucket+=count/k;
       return noOfBucket;
    
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
         int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int nums:bloomDay){
            max=Math.max(max,nums);
            min=Math.min(min,nums);
        }
        int left=min;
        int right=max;
        int ans=0;
         if ((long) m * k > bloomDay.length) {
            return -1;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            ans=solve(bloomDay,m,k,mid);
            if(ans>=m){
               right=mid-1;
            }else{
                left=mid+1;
                
            }
            
        }
        return left;

      
        
    }
}