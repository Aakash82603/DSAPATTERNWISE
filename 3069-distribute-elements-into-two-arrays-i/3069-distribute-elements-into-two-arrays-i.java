class Solution {
    public int[] resultArray(int[] nums) {
        int[]arr1=new int[nums.length];
        int []arr2=new int[nums.length];
        int i=0;
        int j=0;
        arr1[i++]=nums[0];
        arr2[j++]=nums[1];
        for(int k=2; k<nums.length; k++){
            if(arr1[i-1] > arr2[j-1]){
                arr1[i++]=nums[k];
            }else{
                arr2[j++]=nums[k];
            }
        }
        int []result=new int[nums.length];
        for(int k=0; k < i; k++){
            result[k]=arr1[k];
        }
        for(int k=0; k < j; k++){
            result[i+k]=arr2[k];
        }
        return result;
        
    }
}