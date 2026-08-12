class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
          map.put(0,-1);
        // Remainder 0 exists before the array starts
        // This helps detect subarrays starting from index 0
        for(int i=0; i<nums.length; i++){
           sum+=nums[i];
            int rem=sum % k;
             // If this remainder was seen before,
            // the elements between the two indexes have sum divisible by k
            if(map.containsKey(rem)){
                // Check that subarray has at least 2 elements
              if(i - map.get(rem) >=2){//simply finding idex value - previous idex value who get rem if condition stisfied it means already 
              
                return true;
              }
             
            } else{// Store only the first/earliest index of this remainder
                map.put(rem,i);
              }
        }
        return false;
     
        
    }
}