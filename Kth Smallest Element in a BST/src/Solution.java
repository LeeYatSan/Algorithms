////Solution1
//import java.util.ArrayList;
//
//class Solution {
//    public int kthSmallest(TreeNode root, int k) {
//        ArrayList<Integer> arr = new ArrayList();
//        traverse(arr, root);
//        return arr.get(k-1);
//    }
//    private void traverse(ArrayList<Integer> arr, TreeNode root){
//        if(root.left != null)
//            traverse(arr, root.left);
//        arr.add(root.val);
//        if(root.right != null)
//            traverse(arr, root.right);
//    }
//}


//Solution2
class Solution {
    int res = 0;
    int currK = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null)
            return;
        traverse(root.left, k);
        if(currK >= k)
            return;
        if (++currK == k)
            res = root.val;
        traverse(root.right, k);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}