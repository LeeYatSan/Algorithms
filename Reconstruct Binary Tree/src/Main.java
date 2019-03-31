public class Main {
    public static void main(String[] args){
        int[] arr1 = {1,2,4,5,3,6,7};
        int[] arr2 = {4,5,2,6,7,3,1};

        TreeNode result = (new Solution()).constructFromPrePost(arr1, arr2);
        Solution.preOrderPrint(result);
        System.out.println();
        Solution.inOrderPrint(result);
        System.out.println();
        Solution.postOrderPrint(result);
        System.out.println();
    }
}
