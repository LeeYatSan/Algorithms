class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

////Solution1 [Failed]
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
//
//class Solution {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<Integer> depths = new LinkedList<>();
//        Stack<TreeNode> ancestors = new Stack<>();
//        int count = 0;
//        int depth = 1, depth_p = 1, depth_q = 1;
//        TreeNode curr = root, pAncestor = root, qAncestor = root, currAncestor = null;
//        ((LinkedList<TreeNode>) queue).addLast(curr);
//        ((LinkedList<Integer>) depths).addLast(depth);
//        while(!queue.isEmpty()){
//            curr = queue.poll();
//            depth = depths.poll();
//            if(curr == p){
//                ++count;
//                depth_p = depth;
//                pAncestor = currAncestor;
//            }
//            else if(curr == q){
//                ++count;
//                depth_q = depth;
//                qAncestor = currAncestor;
//            }
//            if(count == 2)
//                break;
//            if(curr.left != null){
//                ((LinkedList<TreeNode>) queue).addLast(curr.left);
//                ((LinkedList<Integer>) depths).addLast(depth+1);
//            }
//            if(curr.right != null){
//                ((LinkedList<TreeNode>) queue).addLast(curr.right);
//                ((LinkedList<Integer>) depths).addLast(depth+1);
//            }
//            ancestors.push(currAncestor);
//            currAncestor = curr;
//        }
//        while(pAncestor != qAncestor){
//            if(depth_p > depth_q){
//                pAncestor = ancestors.pop();
//                --depth_p;
//            }
//            else if(depth_p < depth_q){
//                qAncestor = ancestors.pop();
//                --depth_q;
//            }
//            else{
//                pAncestor = ancestors.pop();
//                qAncestor = ancestors.pop();
//                --depth_q;
//                --depth_p;
//            }
//        }
//        return pAncestor;
//    }
//}

//Solution 2
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        else{
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return left == null?right:right == null?left:root;
        }
    }
}