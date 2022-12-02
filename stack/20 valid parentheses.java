/*
https://leetcode.com/problems/valid-parentheses/description/

push open parenthesis on stack -> if closer matches open at end of stack, pop -> otherwise invalid

time: O(n) -> iterate over string -> push/pop/peek stack in O(1)
space: O(n) -> stack
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;

                else if (c == ')' && stack.peek() == '(') stack.pop();  
                else if (c == ']' && stack.peek() == '[') stack.pop();
                else if (c == '}' && stack.peek() == '{') stack.pop();
  
                else return false;
            }
            else {
                stack.push(c);
            }            
        }

        return stack.isEmpty();
    }
}
