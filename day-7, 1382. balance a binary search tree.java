class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        dfs(root, inorder);
        return buildBalancedBST(inorder, 0, inorder.size() - 1);
    }
    
    private void dfs(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        dfs(root.left, inorder);
        inorder.add(root.val);
        dfs(root.right, inorder);
    }
    
    private TreeNode buildBalancedBST(List<Integer> inorder, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(inorder.get(mid));
        node.left = buildBalancedBST(inorder, start, mid - 1);
        node.right = buildBalancedBST(inorder, mid + 1, end);
        return node;
    }
}
