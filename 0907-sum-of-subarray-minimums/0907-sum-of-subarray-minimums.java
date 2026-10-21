class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> nse = nse(arr);
        ArrayList<Integer> pse = pse(arr);

        long sum = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            int left = i - pse.get(i);
            int right = nse.get(i) - i;

            sum = (sum + (long) arr[i] * left * right) % mod;
        }

        return (int) sum;
    }

    public ArrayList<Integer> nse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                list1.add(0, stack.peek());
            } else {
                list1.add(0, n);
            }

            stack.push(i);
        }

        return list1;
    }

    public ArrayList<Integer> pse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                list2.add(stack.peek());
            } else {
                list2.add(-1);
            }

            stack.push(i);
        }

        return list2;
    }
}