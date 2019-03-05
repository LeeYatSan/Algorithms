import java.util.List;

public class Main {
    public static void main(String[] args){
        int[] input = {1, 2, 3};
        Solution s = new Solution();
        List<List<Integer>> results = s.permute(input);
        for(List<Integer> result :results)
            System.out.println(result);
    }
}
