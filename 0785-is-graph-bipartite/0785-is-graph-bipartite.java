class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        Arrays.fill(color, -1);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                color[i] = 0;

                queue.offer(i);

                while (!queue.isEmpty()) {

                    int node = queue.poll();

                    for (int neighbor : graph[node]) {

                        if (color[neighbor] == -1) {

                            color[neighbor] = 1 - color[node];

                            queue.offer(neighbor);

                        } else if (color[neighbor] == color[node]) {

                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}