class Solution {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null || root.right != null)
            swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root){
        root.left = new TreeNode[]{root.right, root.right = root.left}[0];
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}