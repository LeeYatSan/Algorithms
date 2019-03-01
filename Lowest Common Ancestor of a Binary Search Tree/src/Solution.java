import java.util.ArrayList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
    TreeNode(int x) { val = x; }
 }

// //Solution1
//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if((root.val-p.val)*(root.val-q.val) <= 0)
//            return root;
//        else if(root.val >= p.val && root.val >= q.val)
//            return lowestCommonAncestor(root.left, p, q);
//        else
//            return lowestCommonAncestor(root.right, p, q);
//    }
//}

//Solution2
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        int pVal = p.val;
        int qVal = q.val;
        while(curr != null){
            int currVal = curr.val;
            if(currVal > p.val && currVal > q.val)
                curr = curr.left;
            else if(currVal < p.val && currVal < q.val)
                curr = curr.right;
            else
                return curr;
        }
        return null;
    }
}