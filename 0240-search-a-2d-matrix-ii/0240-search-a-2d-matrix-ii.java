class Solution {
    public boolean search(int[] matrix, int x) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid] == x) {
                return true;
            } else if (matrix[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;

        for (int i = 0; i < m; i++) {
            if (search(matrix[i], target)) {
                return true;
            }
        }

        return false;
    }
}