class Solution {
    int[] memo;

    boolean solve(int n) {
        if (n == 0) {
            return false;
        }

        if (memo[n] != -1) {
            return memo[n] == 1;
        }

        for (int k = 1; k * k <= n; k++) {
            if (!solve(n - k * k)) {
                memo[n] = 1;
                return true;
            }
        }

        memo[n] = 0;
        return false;
    }

    public boolean winnerSquareGame(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return solve(n);
    }
}