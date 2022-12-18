/*
https://leetcode.com/problems/daily-temperatures/description/

maintain a stack of indicies -> each day i, pop from stack while temp[stack top] < temp[i] -> set num days for stack top to (i - stack top) -> add i to stack

time: O(n) -> each day gets added to stack once O(n) and resolved once at some later point O(n)
space: O(n) -> stack to store unresolved days, worst case is sorted descending order O(n)
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] out = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                out[j] = i - j;
            }

            stack.push(i);
        }

        return out;
    }
}
