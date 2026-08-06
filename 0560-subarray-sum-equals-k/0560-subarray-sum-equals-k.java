class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix=0;
        int count=0;

        HashMap<Integer, Integer> map=new HashMap<>();
         map.put(0,1);
         for(int i=0; i<nums.length; i++){
            prefix+=nums[i];
            int remove=prefix-k;
            count+=map.getOrDefault(remove,0);
            map.put(prefix,map.getOrDefault(prefix,0)+1);
         }
         return count;

        
    }
}