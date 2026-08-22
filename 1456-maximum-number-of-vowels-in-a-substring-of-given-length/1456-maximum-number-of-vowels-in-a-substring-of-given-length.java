class Solution {
    public int maxVowels(String s, int k) {
        int left = 0, count = 0, max = 0;

        // First window
        for (int right = 0; right < k; right++) {
            char ch = s.charAt(right);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        max = count;

        // Sliding window
        for (int right = k; right < s.length(); right++) {

            char add = s.charAt(right);
            char remove = s.charAt(left);

            if (add == 'a' || add == 'e' || add == 'i' || add == 'o' || add == 'u') {
                count++;
            }

            if (remove == 'a' || remove == 'e' || remove == 'i' || remove == 'o' || remove == 'u') {
                count--;
            }

            left++;

            max = Math.max(max, count);
        }

        return max;
    }
}