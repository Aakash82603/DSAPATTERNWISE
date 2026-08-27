class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int cur = target.charAt(i) - 'a';

            // Try to match target[i]
            if (freq[cur] > 0) {
                ans.append(target.charAt(i));
                freq[cur]--;
                continue;
            }

            // Cannot match, so try a character greater than target[i]
            for (int c = cur + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    ans.append((char) ('a' + c));
                    freq[c]--;

                    // Append remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans.append((char) ('a' + x));
                            freq[x]--;
                        }
                    }

                    return ans.toString();
                }
            }

            // No greater character available.
            // Backtrack to an earlier position.
            while (ans.length() > 0) {
                int last = ans.charAt(ans.length() - 1) - 'a';
                ans.deleteCharAt(ans.length() - 1);
                freq[last]++;

                int pos = ans.length();
                int need = target.charAt(pos) - 'a';

                // Try to make this position greater
                for (int c = need + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        ans.append((char) ('a' + c));
                        freq[c]--;

                        // Remaining characters in sorted order
                        for (int x = 0; x < 26; x++) {
                            while (freq[x] > 0) {
                                ans.append((char) ('a' + x));
                                freq[x]--;
                            }
                        }

                        return ans.toString();
                    }
                }
            }

            return "";
        }

        // We matched target exactly.
        // But we need STRICTLY greater, so backtrack.
        while (ans.length() > 0) {
            int last = ans.charAt(ans.length() - 1) - 'a';
            ans.deleteCharAt(ans.length() - 1);
            freq[last]++;

            int pos = ans.length();
            int need = target.charAt(pos) - 'a';

            for (int c = need + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    ans.append((char) ('a' + c));
                    freq[c]--;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans.append((char) ('a' + x));
                            freq[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}