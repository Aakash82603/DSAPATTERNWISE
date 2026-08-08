class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suf[i] = maximum number of characters
        // we can match from word2[j...] using word1[i...]
        int[] suf = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            suf[i] = suf[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suf[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int p = 0;
        boolean mismatchUsed = false;

        for (j = 0; j < m; j++) {

            while (p < n) {

                // Case 1: exact match
                if (word1.charAt(p) == word2.charAt(j)) {
                    ans[j] = p;
                    p++;
                    break;
                }

                // Case 2: use our one mismatch
                if (!mismatchUsed) {

                    int remaining = m - j - 1;

                    // Can we match everything after p?
                    if (suf[p + 1] >= remaining) {
                        ans[j] = p;
                        p++;
                        mismatchUsed = true;
                        break;
                    }
                }

                p++;
            }

            // We couldn't find an index for word2[j]
            if (p > n) {
                return new int[0];
            }

            // If loop ended without choosing anything
            if (p == n && j < m - 1) {
                return new int[0];
            }
        }

        return ans;
    }
}