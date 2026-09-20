class Solution {
   public int maxindex(int[][] mat, int col) {
        int maxIndex = 0;
        int maxValue = -1;

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=maxindex(mat,mid);
            int left=-1;
            int right=-1;
            if(mid>0){
                left=mat[row][mid-1];
            }
            if(mid<n-1){
                right=mat[row][mid+1];
            }
            if(mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row,mid};
            }else if(left>mat[row][mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
           return new int[]{-1, -1};
    }
}