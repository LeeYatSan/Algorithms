import java.util.List;

public class Main {
    public static void main(String[] args){
        int[] input = {0,0,0};
        Solution s = new Solution();
        List<List<Integer>> results = s.threeSum(input);
        for(List<Integer> result : results)
            System.out.println(result);
    }
}
