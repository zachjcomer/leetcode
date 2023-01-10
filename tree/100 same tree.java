/*
https://leetcode.com/problems/same-tree/description/

if both nodes are null return true -> otherwise, if they are non-null, check their children -> recurse until values are different or one is null -> otherwise check all nodes recursively

time: O(|V|) -> traverse tree in DFS O(|V|) -> check equality O(1)
space: O(|V|) -> height of recursive stack O(|V|)
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null) {
            if (p.val == q.val) {
                return(isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
            }
        }
        return false;
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
 
