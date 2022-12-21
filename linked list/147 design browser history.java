/*
https://leetcode.com/problems/design-browser-history/description/

use a doubly-linked list with a pointer to the current page -> visit overwrites the node's next property -> back/forward traverse the list and return the ending node's value

time: O(n) -> visit/BrowserHistory O(1) -> back/forward require list traversal from pointer O(n)
space: 
*/

class DoubleLinkedList {
    DoubleLinkedList prev;
    DoubleLinkedList next;
    String val;

    public DoubleLinkedList(String val) {
        this.prev = null;
        this.next = null;
        this.val = val;
    }

    public void add(String val) {
        DoubleLinkedList next = new DoubleLinkedList(val);
        this.next = next;
        next.prev = this;
    }
}

class BrowserHistory {
    private DoubleLinkedList root;
    private DoubleLinkedList cur;

    public BrowserHistory(String homepage) {
        this.root = new DoubleLinkedList(homepage);
        this.cur = root;
    }
    
    public void visit(String url) {
        this.cur.add(url);
        this.cur = this.cur.next;
    }
    
    public String back(int steps) {
        while (this.cur.prev != null && steps > 0) {
            this.cur = this.cur.prev;
            steps--;
        }

        return cur.val;
    }
    
    public String forward(int steps) {
        while (this.cur.next != null && steps > 0) {
            this.cur = this.cur.next;
            steps--;
        }

        return this.cur.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
