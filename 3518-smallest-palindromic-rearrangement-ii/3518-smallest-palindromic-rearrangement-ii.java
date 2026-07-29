import java.util.*;

class Solution {

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder mid = new StringBuilder();
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid.append((char) ('a' + i));
            }
            half[i] = freq[i] / 2;
        }

        int halfLen = s.length() / 2;

        if (countWays(half, halfLen) < k)
            return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {

            for (int ch = 0; ch < 26; ch++) {

                if (half[ch] == 0)
                    continue;

                half[ch]--;

                long ways = countWays(half, halfLen - pos - 1);

                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                } else {
                    k -= ways;
                    half[ch]++;
                }
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left.toString() + mid.toString() + right.toString();
    }

    private long countWays(int[] half, int total) {

        long res = 1;

        int remain = total;

        for (int c : half) {
            if (c == 0)
                continue;
            res *= combination(remain, c);
            if (res > 1000000000L)
                res = 1000000000L;
            remain -= c;
        }

        return res;
    }

    private long combination(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans > 1000000000L)
                return 1000000000L;
        }

        return ans;
    }
}