class Solution {
    public int missingMultiple(int[] nums, int k) {
        int multiple=k;
        HashSet<Integer>set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        while(set.contains(multiple)){
            multiple+=k;
        }
        return multiple;
       
        
    }
}