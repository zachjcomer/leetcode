/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

BFS to do in level order traversal -> if level is odd, add to output from 0 to reverse order

time: O(|V + E|) -> BFS traversal of tree
space: O(|V|) -> every node is in a single list
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> out = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }
        int level = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level_out = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                if (level % 2 == 0) {
                    level_out.add(cur.val);
                }
                else {
                    level_out.add(0, cur.val);
                }
                
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            out.add(level_out);
            level++;
        }

        return out;
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
