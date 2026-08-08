class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefix=0;
        int count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);

        for(int i=0; i<nums.length; i++){
            prefix+=nums[i];
           int remainder = ((prefix % k) + k) % k;
                count+=map.getOrDefault(remainder,0);
            
            map.put(remainder, map.getOrDefault(remainder,0)+1);
        }
        return count;
        
    }
}