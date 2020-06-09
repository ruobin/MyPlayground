package algo;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (c == ')' && (Character) stack.pop() == '(') {
                        continue;
                    }
                    if (c == '}' && (Character) stack.pop() == '{') {
                        continue;
                    }
                    if (c == ']' && (Character) stack.pop() == '[') {
                        continue;
                    }
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
