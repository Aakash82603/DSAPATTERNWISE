class Solution {
    int dp[][];
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
       dp=new int[n][n];
       for(int i=0; i<n; i++){
        Arrays.fill(dp[i],Integer.MIN_VALUE);
       }
       return solve(piles,0,n-1)>0;
            
    }
    private int solve(int[]piles, int i, int j){
        if(i==j) {
            return piles[i];
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int left=piles[i]-solve(piles, i+1,j);
        int right=piles[j]-solve(piles, i,j-1);
        dp[i][j]=Math.max(left,right);
        return dp[i][j];
    }
}