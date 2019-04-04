//Solution1
class Solution {
    TreeNode target;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        target = t;
        return sub(s, t);
    }

    private boolean sub(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val != t.val ? sub(s.left, target) || sub(s.right, target) : (sub(s.left, t.left) && sub(s.right, t.right)) || sub(s.left, t) || sub(s.right, t);
    }
}

////Solution2
//public class Solution {
//
//    public boolean isSubtree(TreeNode root1, TreeNode root2) {
//        if(root1 == null || root2 == null)
//            return false;
//        return sub(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
//    }
//
//    private boolean sub(TreeNode s, TreeNode t) {
//        if (s == null && t == null) return true;
//        if (s == null || t == null) return false;
//        return s.val == t.val && sub(s.left, t.left) && sub(s.right, t.right);
//    }
//}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}