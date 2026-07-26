class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

        for(int j=i+1; j<nums.length-2; j++){
            if(j>i+1 && nums[j]==nums[j-1]){
                continue;
            }
            int k=j+1;
            int l=nums.length-1;
            while(k<l){
                long sum= (long)nums[i] + nums[j]+ nums[k]+nums[l];
            
            if(sum > target){
                l--;
            }
            else if(sum < target){
                k++;
            }
            else{
                list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
            
            while(k<l && nums[l]==nums[l-1]){
                l--;
            }
            while(k<l && nums[k]==nums[k+1])
            {
                k++;
            }
            l--;
            k++;
        }
            }
      }
      }
      return list;
        
    }
}