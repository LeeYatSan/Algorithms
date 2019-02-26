public class Main {
    public static void main(String[] args){
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2, 4}};
        Solution s = new Solution();
        System.out.println(s.robotSim(commands, obstacles));
    }
}
