class Solution {
     int [][]dp=new int[1001][1001];
    int solve(String s, String t,int m, int n){
       
        if(n==0){
            return dp[m][n]= 1;
        }
        if (m==0){
            return dp[m][n]= 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(s.charAt(m-1)==t.charAt(n-1)){
            return dp[m][n]= solve(s,t,m-1,n-1) + solve(s,t,m-1,n);
        }else{
            return dp[m][n]= solve(s,t,m-1,n);
        }

    }
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                 dp[i][j]=-1;
            }
        }
        
        return solve(s,t,m,n);
        
    }
}