class Solution {

    public int distinctSubseqII(String s) {

        int modulo = 1000000007;
        int n = s.length();

        // dp[i] = number of distinct subsequences
        // using first i characters, including empty subsequence
        long[] dp = new long[n + 1];

        dp[0] = 1;

        // Stores the last contribution of each character
        long[] last = new long[26];

        for (int i = 1; i <= n; i++) {

            int ch = s.charAt(i - 1) - 'a';

            // Every previous subsequence can either take or
            // not take the current character
            dp[i] = (2 * dp[i - 1]) % modulo;

            // Remove duplicate subsequences created by
            // the previous occurrence of this character
            dp[i] = (dp[i] - last[ch] + modulo) % modulo;

            // Current dp becomes the latest contribution
            last[ch] = dp[i - 1];
        }

        // Remove empty subsequence
        return (int) ((dp[n] - 1 + modulo) % modulo);
    }
}