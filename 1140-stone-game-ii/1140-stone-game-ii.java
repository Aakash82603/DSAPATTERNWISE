import java.util.Arrays;

class Solution {

    int n;
    int[][][] dp;

    int solveForAlice(int[] piles, int person, int i, int m) {

        // All piles are taken
        if (i >= n) {
            return 0;
        }

        // Already calculated
        if (dp[person][i][m] != -1) {
            return dp[person][i][m];
        }

        // Alice -> maximize
        // Bob -> minimize Alice's stones
        int result = (person == 1) ? -1 : Integer.MAX_VALUE;

        int stone = 0;

        // We can take X piles, where 1 <= X <= 2 * M
        for (int x = 1; x <= Math.min(2 * m, n - i); x++) {

            stone += piles[i + x - 1];

            int newM = Math.max(m, x);

            if (person == 1) {

                // Alice's turn
                result = Math.max(result,stone + solveForAlice(piles, 0, i + x,newM ));

            } else {

                // Bob's turn
                result = Math.min(result,solveForAlice(piles,1,i + x,newM  ));
            }
        }

        return dp[person][i][m] = result;
    }

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[2][n][n + 1];

        // Initialize DP with -1
        for (int person = 0; person < 2; person++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[person][i], -1);
            }
        }

        // Alice starts at index 0 with M = 1
        return solveForAlice(piles, 1, 0, 1);
    }
}