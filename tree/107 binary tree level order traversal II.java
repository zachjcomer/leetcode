/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

traverse in BFS -> use queue/length of queue to track level -> add same-level vertices to a list -> reverse the output list

time: O(|V| + |E|) -> BFS -> O(|V|) to reverse the list
space: O(|V|) -> all verts in a list
*/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> out = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level_out = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                level_out.add(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            out.add(0, level_out);
            level++;
        }

        return out;
    }
}
