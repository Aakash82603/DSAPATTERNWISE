
import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {//base case
            char ch = num.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (k > 0) { // edge case 1; like num:1234 for that we reoove last k didgit
            stack.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {//converting stack inti string
            ans.append(ch);
        }

        while (ans.length() > 0 && ans.charAt(0) == '0') {//rremoving starting 0 like 020000 so it must be 20000
            ans.deleteCharAt(0);
        }

        if (ans.length() == 0) { // if num=000 int hat case return 0
            return "0";
        }

        return ans.toString();// string builder to string
    }
}
