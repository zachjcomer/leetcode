/*
https://leetcode.com/problems/leaf-similar-trees/description/

for each tree use DFS to perform a pre-order traversal -> if a node is a leaf, add it to the list -> compare the leaf lists

time: O(|V| + |E|) -> DFS on both trees -> O(|V|) comparing the root lists
space: O(|V|) -> root lists for each tree
*/

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> out1 = new LinkedList<>();
        List<Integer> out2 = new LinkedList<>();
        DFS(out1, root1);
        DFS(out2, root2);

        if (out1.size() != out2.size()) return false;
        for (int i = 0; i < out1.size(); i++) {
            if (out1.get(i) != out2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void DFS(List<Integer> out, TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                out.add(root.val);
            }
            else {
                if (root.left != null) {
                    DFS(out, root.left);
                }
                if (root.right != null) {
                    DFS(out, root.right);
                }
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
 
