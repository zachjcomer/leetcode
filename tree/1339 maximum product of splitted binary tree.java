/*
https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/

pass 1: compute the entire tree sum recursively
pass 2: split prod of node = (sum of descendants) * (total - sum of descendants)

time: O(|V| + |E|) ->
space: O(|V|) -> size of tree kept in recursive stack
*/

class Solution {
    long tree_sum = 0;
    long max = 0;
    long partial = 0;

    public int maxProduct(TreeNode root) {
        tree_sum = DFS(root);
        DFS(root);
        return (int) (max % (1e9 + 7));
    }

    private long DFS(TreeNode root) {
        if (root == null) return 0;

        partial = root.val + DFS(root.left) + DFS(root.right); // pass 1
        max = Math.max(max, partial * (tree_sum - partial)); // pass 2
        return partial; // pass 1
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
