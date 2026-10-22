
import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        return maximum(nums) - minimum(nums);
    }

    // Next Smaller Element
    public ArrayList<Integer> nse(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                list.add(stack.peek());
            } else {
                list.add(n);
            }

            stack.push(i);
        }

        Collections.reverse(list);
        return list;
    }

    // Previous Smaller Element
    public ArrayList<Integer> pse(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                list.add(stack.peek());
            } else {
                list.add(-1);
            }

            stack.push(i);
        }

        return list;
    }

    // Next Greater Element
    public ArrayList<Integer> nge(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                   nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                list.add(stack.peek());
            } else {
                list.add(n);
            }

            stack.push(i);
        }

        Collections.reverse(list);
        return list;
    }

    // Previous Greater Element
    public ArrayList<Integer> pge(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() &&
                   nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                list.add(stack.peek());
            } else {
                list.add(-1);
            }

            stack.push(i);
        }

        return list;
    }

    // Sum of Subarray Minimums
    public long minimum(int[] nums) {
        int n = nums.length;
        long summin = 0;

        ArrayList<Integer> next = nse(nums);
        ArrayList<Integer> prev = pse(nums);

        for (int i = 0; i < n; i++) {
            long left = i - prev.get(i);
            long right = next.get(i) - i;

            summin += left * right * nums[i];
        }

        return summin;
    }

    // Sum of Subarray Maximums
    public long maximum(int[] nums) {
        int n = nums.length;
        long summax = 0;

        ArrayList<Integer> next = nge(nums);
        ArrayList<Integer> prev = pge(nums);

        for (int i = 0; i < n; i++) {
            long left = i - prev.get(i);
            long right = next.get(i) - i;

            summax += left * right * nums[i];
        }

        return summax;
    }
}
