class Solution {
    public int missingInteger(int[] nums) {
        int count=nums[0];
      
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]+1){
                count+=nums[i];
            }else{
                break;
            }
            
        }
        while(true){//findiing missing element if yes true just break and increse the count and search again
            boolean found= false;
             for(int i=0; i<nums.length; i++){
            if(nums[i]==count){
                found= true;
                break;
            }
        }if(!found){
            return count;
        }
        count++;
        }
       
        
    }
}