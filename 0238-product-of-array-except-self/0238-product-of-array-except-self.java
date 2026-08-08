class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefixpro=1;
        int suffixpro=1;
        int []answer=new int[nums.length];
    
        
        for(int i=0; i<nums.length; i++){
            answer[i]=prefixpro;
            prefixpro*=nums[i];
             
        }
            
        for(int i=nums.length-1; i>=0; i--){
          
             answer[i] *= suffixpro;
            suffixpro *= nums[i];
             
        }
        return answer;
     
        
    }
}