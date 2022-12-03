/*
https://leetcode.com/problems/min-stack/description/
pair.getKey(), pair.getValue() https://docs.oracle.com/javase/9/docs/api/javafx/util/Pair.html

approach 1: single stack of pairs -> key = val, value = min at insertion, either val or value from previous pair on stack
approach 2: one stack for pushing/popping nums, one for min -> if min (top of min stack) popped from nums, pop min stack

time: O(1) -> min is stored/retrieved in O(1) -> top/getMin in O(1)
space: O(n) -> one or two stacks of all pushed nums
*/

// approach 1
class MinStack {
    private Stack<Pair<Integer, Integer>> nums;

    public MinStack() {
        nums = new Stack<>();
    }
    
    public void push(int val) {  
        if (nums.isEmpty() || val <= nums.peek().getValue()) {
            nums.push(new Pair(val, val));
        }
        else {
            nums.push(new Pair(val, nums.peek().getValue()));
        }
    }
    
    public void pop() {
        nums.pop();
    }
    
    public int top() {
        return nums.peek().getKey();
    }
    
    public int getMin() {
        return nums.peek().getValue();
    }
}

// approach 2
class MinStack {
    private Stack<Integer> nums;
    private Stack<Integer> min;

    public MinStack() {
        nums = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {  
        if (min.isEmpty()) {
            nums.push(val);
            min.push(val);
        }
        else if (val <= min.peek()) {
            nums.push(val);
            min.push(val);
        }
        else {
            nums.push(val);
        }
    }
    
    public void pop() {
        if (nums.peek() <= min.peek()) {
            nums.pop();
            min.pop();
        }
        else {
            nums.pop();
        }
    }
    
    public int top() {
        return nums.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
