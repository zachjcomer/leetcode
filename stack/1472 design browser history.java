/*
https://leetcode.com/problems/design-browser-history/description/

use two stacks -> go back by popping and pushing to a reverse stack -> go forward by popping from the reverse stack -> current page = top of main stack -> add page by clearing reverse and pushing to main stack

time: O(n) -> visit, BrowserHistory just push to stack O(1) -> back, forward must pop/push stacks O(n)
space: O(n) -> the two stacks hold O(n) pages
*/

class BrowserHistory {
    private Stack<String> mainStack;
    private Stack<String> revStack;

    public BrowserHistory(String homepage) {
        mainStack = new Stack<>();
        revStack = new Stack<>();

        mainStack.push(homepage);
    }
    
    public void visit(String url) {
        mainStack.push(url);
        revStack.clear();
    }
    
    public String back(int steps) {
        while (mainStack.size() > 1 && steps > 0) {
            revStack.push(mainStack.pop());
            steps--;
        }
        return mainStack.peek();
    }
    
    public String forward(int steps) {
        while (!revStack.isEmpty() && steps > 0) {
            mainStack.push(revStack.pop());
            steps--;
        }

        return mainStack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
