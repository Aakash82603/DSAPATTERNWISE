class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check whether palindrome is possible
        int odd = 0;
        int mid = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                mid = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        // Characters available for first half
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        StringBuilder first = new StringBuilder();

        // Try to match target's first half
        for (int i = 0; i < n / 2; i++) {

            int need = target.charAt(i) - 'a';

            if (half[need] > 0) {
                // Keep equal
                first.append((char) ('a' + need));
                half[need]--;
            } 
            else {
                // Cannot keep equal.
                // Try smallest character greater than target[i].
                for (int c = need + 1; c < 26; c++) {

                    if (half[c] > 0) {
                        first.append((char) ('a' + c));
                        half[c]--;

                        return buildPalindrome(first, half, mid);
                    }
                }

                // Current position cannot be increased.
                return backtrack(first, half, target, mid);
            }
        }

        /*
         * We have matched the entire first half.

         * IMPORTANT:
         * The complete palindrome may already be > target
         * because of the middle/right half.
         */
        String candidate = buildPalindrome(first, half, mid);

        if (candidate.compareTo(target) > 0) {
            return candidate;
        }

        // Candidate is equal or smaller.
        // Now we need to increase an earlier first-half position.
        return backtrack(first, half, target, mid);
    }


    private String backtrack(StringBuilder first,
                             int[] half,
                             String target,
                             int mid) {

        while (first.length() > 0) {

            // Remove last chosen character
            int last = first.charAt(first.length() - 1) - 'a';

            first.deleteCharAt(first.length() - 1);
            half[last]++;

            int pos = first.length();
            int need = target.charAt(pos) - 'a';

            // Try the smallest character greater than target[pos]
            for (int c = need + 1; c < 26; c++) {

                if (half[c] > 0) {

                    first.append((char) ('a' + c));
                    half[c]--;

                    return buildPalindrome(first, half, mid);
                }
            }
        }

        return "";
    }


    private String buildPalindrome(StringBuilder first,
                                    int[] half,
                                    int mid) {

        // Make the remaining first-half characters smallest
        for (int c = 0; c < 26; c++) {
            while (half[c] > 0) {
                first.append((char) ('a' + c));
                half[c]--;
            }
        }

        StringBuilder ans = new StringBuilder();

        // First half
        ans.append(first);

        // Middle character
        if (mid != -1) {
            ans.append((char) ('a' + mid));
        }

        // Reverse first half
        for (int i = first.length() - 1; i >= 0; i--) {
            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
}