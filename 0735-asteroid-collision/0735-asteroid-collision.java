
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];

            if (curr > 0) {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(curr)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(curr)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(curr);
                }
            }
        }

        int[] ans = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }

        return ans;
    }
}
