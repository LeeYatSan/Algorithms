public class Main {
    public static void main(String args[]){
        int[] input = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(input);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
