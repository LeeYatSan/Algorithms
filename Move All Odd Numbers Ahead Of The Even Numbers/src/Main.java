public class Main {
    public static void main(String[] args){
        int[] input = {2,2,2,4,8,1,3};
        (new Solution()).reOrderArray(input);
        for(int curr : input)
            System.out.print(curr + " ");
    }
}
