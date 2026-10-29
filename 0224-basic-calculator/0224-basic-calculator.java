
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                number = number * 10 + (s.charAt(i) - '0');

            } else if (s.charAt(i) == '+') {
                result += number * sign;
                number = 0;
                sign = 1;

            } else if (s.charAt(i) == '-') {
                result += number * sign;
                number = 0;
                sign = -1;

            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);

                number = 0;
                result = 0;
                sign = 1;

            } else if (s.charAt(i) == ')') {
                result += number * sign;
                number = 0;

                int lastSign = stack.pop();
                int lastResult = stack.pop();

                result = result * lastSign + lastResult;
            }
        }

        result += number * sign;
        return result;
    }
}
