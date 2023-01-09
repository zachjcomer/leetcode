/*
https://leetcode.com/problems/binary-tree-preorder-traversal/description/

visit nodes in a DFS -> add the current node to the output list -> recurse on the left and right subtrees

time: O(|V|) -> preorder traversal O(|V|) -> add to list O(1)
space: O(|V|) -> height of recursive stack O(|V|) -> size of output list O(|V|)
*/

class Solution {
    private List<Integer> out;

    public List<Integer> preorderTraversal(TreeNode root) {
        out = new LinkedList<>();
        DFS(root);

        return out;
    }

    private void DFS(TreeNode current) {
        if (current != null) {
            out.add(current.val);

            if (current.left != null) {
                DFS(current.left);
            }

            if (current.right != null) {
                DFS(current.right);
            }
        }
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
