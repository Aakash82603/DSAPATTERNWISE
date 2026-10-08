class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int index = 0;

        while (right < n) {

            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            // Add current index
            deque.addLast(right);

            // Window size = right - left + 1
            if (right - left + 1 == k) {

                // Front contains index of maximum element
                result[index] = nums[deque.peekFirst()];
                index++;

                // Remove left element if it is outside window
                if (deque.peekFirst() == left) {
                    deque.pollFirst();
                }

                left++;
            }

            right++;
        }

        return result;
    }
}