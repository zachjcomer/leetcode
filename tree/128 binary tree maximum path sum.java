/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

find max path sum ending at node -> check L/R subtrees -> max path through node could include maxes from L/R/both/neither 
use max L/R recursive callbacks to find local max path and compare to global -> return max path ending at current

time: O(|V|) -> recursively computing sums of descendant nodes
space: O(|V|) -> height of recursive stack
*/

class Solution {
    int path = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max_path(root);
        return path;
    }

    private int max_path(TreeNode node) {
        if (node == null) return 0;

        // max sums of paths ending at node.left, node.right
        int left_path = max_path(node.left);
        int right_path = max_path(node.right);

        // use ^ to find max sum path incident on node
        int current_path = Math.max(
            Math.max(
                node.val,
                node.val + left_path + right_path
            ),
            Math.max(
                node.val + left_path,
                node.val + right_path
            )
        );

        // and compare ^ to global
        path = Math.max(path, current_path);
        
        // max sum path ENDING at node include at MOST one subtree max sum path
        return Math.max(
            Math.max(
                node.val + left_path,
                node.val + right_path
            ),
            node.val
        );
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
