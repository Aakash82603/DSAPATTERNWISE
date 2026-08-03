class Solution {

    public boolean isValid(String s) {

        Stack<Character> stacks = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {

                stacks.push(ch);

            } else {
                if(stacks.empty()){
                    return false;
                }
                char top=stacks.peek();
                if((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{')){
                        stacks.pop();
                    }
                    else{
                        return false;
                    }
            }
        }

           return stacks.isEmpty();
    }
}