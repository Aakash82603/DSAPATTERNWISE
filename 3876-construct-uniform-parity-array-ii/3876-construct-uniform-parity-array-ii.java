class Solution {
    public boolean uniformArray(int[] nums1) {
     int min=nums1[0];
     for(int num:nums1){
        min=Math.min(min,num);
     }
     //if min is even we simply array all odd
     if(min%2!=0){
        return true;
     }
     //if min is even sowe have to chek the every elemt is even or not
     for(int num:nums1){
        if(num%2!=0){
            return false;
        }
     }
     return true;

        
    }
}