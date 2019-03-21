public class Main {
    public static void main(String[] args){
        int[] listA = {1,2,3,4,5,7,20,34,49};
        int[] listB = {9,21,20,55};
        int K = 3;
        Solution s = new Solution();
        System.out.println(s.searchKthLargest(listA, listB, K));
    }
}
