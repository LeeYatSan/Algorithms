import java.util.List;

public class Main {
    public static void main(String[] args){
        int[] input = {1, 2, 3, 4};
        Solution s = new Solution();
        List<List<Integer>> results = s.subsets(input);
        for(List<Integer> result : results){
            System.out.println(result);
        }
    }
}
