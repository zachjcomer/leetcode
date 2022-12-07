/*
https://leetcode.com/problems/range-sum-of-bst/description/

visit nodes recursively -> add their value if valid -> visit valid subtrees

time: O(|V + E|) -> traverse entire graph -> count vertex value if valid
space: O(|V|) -> nodes in recursion stack could be up to |V|
*/

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        else if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        else {
            return rangeSumBST(root.left, low, high);
        }
    }
}

/*
visit nodes in a BFS -> add value if valid -> add valid subtrees to queue

space O(|V|) -> nodes in queue up to |V| 
*/


class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;

        if (root != null) {
            queue.add(root);
        }

        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur != null) {
                if (cur.val >= low && cur.val <= high) {
                    sum += cur.val;
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }
                else if (cur.val < low) {
                    queue.add(cur.right);
                }
                else {
                    queue.add(cur.left);
                }
            }
        }
        return sum;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
