class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length*post.length == 0 || pre.length != post.length)
            return null;
        return reconstructFromPrePost(pre, post, 0, pre.length-1, 0, post.length-1);
    }

    public TreeNode constructFromInPost(int[] in, int[] post) {
        if(in.length*post.length == 0 || in.length != post.length)
            return null;
        return reconstructFromInPost(in, post, 0, in.length-1, 0, post.length-1);
    }

    public TreeNode constructFromPreIn(int[] pre, int[] in) {
        if(in.length*pre.length == 0 || in.length != pre.length)
            return null;
        return reconstructFromPreIn(pre, in, 0, pre.length-1, 0, in.length-1);
    }

    private TreeNode reconstructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd){
        TreeNode root = null;
        if(preStart > preEnd || postStart >postEnd)
            return root;
        root  = new TreeNode(pre[preStart]);
        for (int i = postStart ; i <= postEnd ; i++) {
            if (preStart+1 <= preEnd && pre[preStart+1] == post[i]) {
                root.left = reconstructFromPrePost(pre, post, preStart+1, preStart+1+(i-postStart), postStart, i);
                root.right = reconstructFromPrePost(pre, post, preStart+1+(i-postStart)+1, preEnd, i+1, postEnd-1);
                break;
            }
        }
        return root;
    }

    private TreeNode reconstructFromInPost(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd){
        TreeNode root = null;
        if(inStart > inEnd || postStart >postEnd)
            return root;
        root  = new TreeNode(post[postEnd]);
        for (int i = inStart ; i <= inEnd ; i++) {
            if (in[i] == post[postEnd]) {
                root.left = reconstructFromInPost(in, post, inStart, i-1, postStart, postStart+(i-inStart)-1);
                root.right = reconstructFromInPost(in, post, i+1, inEnd, postStart+(i-inStart), postEnd-1);
                break;
            }
        }
        return root;
    }

    private TreeNode reconstructFromPreIn(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        TreeNode root = null;
        if(preStart > preEnd || inStart > inEnd)
            return root;
        root  = new TreeNode(pre[preStart]);
        for (int i = inStart ; i <= inEnd ; i++) {
            if (in[i] == pre[preStart]) {
                root.left = reconstructFromPreIn(pre, in, preStart+1, preStart+(i-inStart), inStart, i-1);
                root.right = reconstructFromPreIn(pre, in, preStart+(i-inStart)+1, preEnd, i+1, inEnd);
                break;
            }
        }
        return root;
    }

    static void preOrderPrint(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            preOrderPrint(root.left);
            preOrderPrint(root.right);
        }
    }

    static void inOrderPrint(TreeNode root){
        if(root != null){
            inOrderPrint(root.left);
            System.out.print(root.val + " ");
            inOrderPrint(root.right);
        }
    }

    static void postOrderPrint(TreeNode root){
        if(root != null){
            postOrderPrint(root.left);
            postOrderPrint(root.right);
            System.out.print(root.val + " ");
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}