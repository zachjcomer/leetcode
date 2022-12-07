/*
https://leetcode.com/problems/binary-tree-level-order-traversal/

approach 1:
binary tree -> level order traversal -> BFS
nodes in queue at start = in same level => put all nodes in queue in same list -> put list in larger list

approach 2:
DFS pre-order traversal goes to leftmost vert possible -> visits each level in order -> add to list based on current height

time: O(V + E) = O(V) -> visit each TreeNode once
space: O(V) -> every TreeNode appears in the final list once
*/

// approach 1
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

// approach 2
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();
        DFS(out, root, 0);
        return out;
    }

    private void DFS(List<List<Integer>> out, TreeNode root, int h) {
        if (root != null) {
            if (h == out.size()) {
                out.add(h, new LinkedList<>());
            }
            out.get(h).add(root.val);

            DFS(out, root.left, h + 1);
            DFS(out, root.right, h + 1);
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
