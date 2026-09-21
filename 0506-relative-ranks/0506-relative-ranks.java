class Solution {
    public String[] findRelativeRanks(int[] score) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        int[] sorted = score.clone();
        Arrays.sort(sorted);

        String[] ans = new String[score.length];

        for (int i = 0; i < score.length; i++) {

            int value = sorted[score.length - 1 - i];

            int orgindex = map.get(value);

            if (i == 0) {
                ans[orgindex] = "Gold Medal";
            }
            else if (i == 1) {
                ans[orgindex] = "Silver Medal";
            }
            else if (i == 2) {
                ans[orgindex] = "Bronze Medal";
            }
            else {
                ans[orgindex] = String.valueOf(i + 1);
            }
        }

        return ans;
    }
}