class Solution {
    public int maxProduct(int[] nums) {
       Arrays.sort(nums);
       int i=nums.length-2;
       int j=nums.length-1;
       int max =(nums[i]-1) * (nums[j]-1);
        return max; 
    }
}