class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0;
        int left=0;
       
      for(int right=left; right<nums.length; right++){
        map.put(nums[right],map.getOrDefault(nums[right],0)+1);
        while(map.get(nums[right])>k){
            map.put(nums[left],map.get(nums[left])-1);
            if(map.get(nums[left])==0){
                map.remove(nums[left]);
            }
            left++;
        }
        count=Math.max(count,right-left+1);
      }
      return count;
        
    }
}