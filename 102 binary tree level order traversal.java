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
