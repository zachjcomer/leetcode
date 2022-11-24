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

/*
binary tree -> level order traversal -> BFS
nodes in queue at start = in same level => put all nodes in queue in same list -> put list in larger list
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.add(root);
        int lvl = 0;
        
        while (!queue.isEmpty()) {

            int len = queue.size();
            List<Integer> listLevel = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();

                listLevel.add(cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);

            }

            list.add(listLevel);
            lvl++;
        }

        return list;
    }
}
