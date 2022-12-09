/*
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

mAD = max of (|current val - min/max ancestor vals| or some other descendant node's mAD) -> pass max/min of the tree to subtrees recursively

time: O(|V|) -> visit each node once O(V) -> recurse on descendant mADs O(1) [non-recursive work] -> calc mAD for current O(1)
space: O(|V|) -> number of verts possibly kept in memory during recursion
*/

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dif2(root, root.val, root.val);
    }

    private int dif2(TreeNode root, int max_above, int min_above) {
        if (root != null) {
            return Math.max(
                Math.max(
                    dif2(root.left, Math.max(max_above, root.val), Math.min(min_above, root.val)),
                    dif2(root.right, Math.max(max_above, root.val), Math.min(min_above, root.val))
                ),
                Math.max(
                    Math.abs(root.val - max_above),
                    Math.abs(root.val - min_above)
                )
            );
        }
        else return 0;
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
 
