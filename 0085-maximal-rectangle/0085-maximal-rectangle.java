
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int index = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea,
                    heights[index] * (nse - pse - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int index = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea,
                heights[index] * (nse - pse - 1));
        }

        return maxArea;
    }
}
