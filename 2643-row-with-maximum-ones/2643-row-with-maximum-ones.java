class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int countmax = 0;
        int index = 0;

        for (int i = 0; i < m; i++) {
            int countones = 0;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    countones++;
                }
            }

            if (countones > countmax) {
                countmax = countones;
                index = i;
            }
        }

        return new int[]{index, countmax};
    }
}