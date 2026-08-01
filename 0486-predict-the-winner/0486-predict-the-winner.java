import java.util.Arrays;

class Solution {

    int[][] t = new int[23][23];

    int solve(int i, int j, int[] nums) {

        if (i > j) return 0;

        if (i == j) return nums[i];

        if (t[i][j] != -1) return t[i][j];

        int take_i = nums[i] + Math.min(
                solve(i + 2, j, nums),
                solve(i + 1, j - 1, nums)
        );

        int take_j = nums[j] + Math.min(
                solve(i + 1, j - 1, nums),
                solve(i, j - 2, nums)
        );

        return t[i][j] = Math.max(take_i, take_j);
    }

    public boolean predictTheWinner(int[] nums) {

        for (int[] row : t)
            Arrays.fill(row, -1);

        int totalScore = 0;

        for (int num : nums)
            totalScore += num;

        int player1_score = solve(0, nums.length - 1, nums);
        int player2_score = totalScore - player1_score;

        return player1_score >= player2_score;
    }
}