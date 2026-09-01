class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int[] pcount = new int[26];
        int[] scount = new int[26];
        ArrayList<Integer> result = new ArrayList<>();

        // Frequency counting of p
        for (char ch : p.toCharArray()) {
            pcount[ch - 'a']++;
        }

        // Sliding window
        for (int i = 0; i < s.length(); i++) {

            // Add current character
            scount[s.charAt(i) - 'a']++;

            // Remove old character
            if (i >= p.length()) {
                scount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare counts
            if (Arrays.equals(pcount, scount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}