/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

map operators to lambda expressions -> if token is operator, evaluate top two integers on stack -> else, push integer to stack

time: O(n) -> get integers for expression in O(1) -> evaluate expression in O(1) from BiFunction -> n tokens
space: O(n) -> storing non-operator tokens in stack -> operator BiFunction map is O(1)
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> b - a);
        map.put("*", (a, b) -> a * b);
        map.put("/", (a, b) -> b / a);

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            char c = token.charAt(0);
            if (map.containsKey(token)) {
                stack.push(map.get(token).apply(stack.pop(), stack.pop()));
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
