////solution1: recursive way, but exceeds time limit ! Bad!

//class Solution {
//    private int way = 0;
//
//    public int climbStairs(int n){
//        if(n < 0) return 0;
//        else {
//            wayNode start = new wayNode(n, this);
//            start.upStair();
//            return this.getWay();
//        }
//    }
//
//    public void addWay(){++way;}
//
//    public int getWay(){return way;}
//
//}
//
//
////we define that left way needs 1 step, and the right way needs two steps
//class wayNode{
//    private wayNode left = null, right = null;
//    private int left_steps, right_steps;
//    private Solution s;
//
//    wayNode(int n, Solution s){
//        this.left_steps = n;
//        this.right_steps = n;
//        this.s = s;
//    }
//
//    private boolean isTerminal(){
//        if(left_steps == 0 && right_steps ==0) return true;
//        else return false;
//    }
//
//    private void upOneStep(){
//        this.left = new wayNode(left_steps-1, this.s);
//        if(this.left.isTerminal()) s.addWay();
//        this.left.upStair();
//    }
//
//    private void upTwoSteps(){
//        this.right =  new wayNode(right_steps-2, this.s);
//        if(this.right.isTerminal()) s.addWay();
//        this.right.upStair();
//    }
//
//    public void upStair(){
//        if(left_steps != 0) upOneStep();
//        if(right_steps > 1) upTwoSteps();
//    }
//}

////solution2: recursive way, also exceeds time limited
//class Solution {
//    public int climbStairs(int n) {
//        if(n == 0)
//            return 0;
//        else if(n == 1)
//            return 1;
//        else if(n == 2)
//            return 2;
//        else
//            return climbStairs(n-1)+climbStairs(n-2);
//    }
//}



//solution 3: Dynamic Programming - the optimized version of solution 2, which uses an array to store the result of each recursive process, preventing the duplicate calculations and greatly decreasing the time the program needs
//import java.util.Arrays;
//
//class Solution {
//
//    private int[] remain_step;
//
//    public int climbStairs(int n) {
//        remain_step = new int[n+1];
//        Arrays.fill(remain_step, -1);
//        return getClimbStairs(n);
//
//    }
//
//    private int getClimbStairs(int n){
//        if(n == 1)
//            return 1;
//        if(n == 2)
//            return 2;
//        if(remain_step[n] == -1)
//            remain_step[n] = getClimbStairs(n-1)+getClimbStairs(n-2);
//        return remain_step[n];
//    }
//}


//solution 4: Dynamic Programming - from the top to the bottom. To start, by observing the array of the stair-step, we can find that it is Fibonacci numbers.

class Solution{

    public int climbStairs(int n){
        int remain_step_i = 1, remain_step_i_1 = 1, remain_step_i_2 = 0;
        for(int i = 2; i <= n+1; ++i){
            remain_step_i = remain_step_i_2 + remain_step_i_1;
            remain_step_i_2 = remain_step_i_1;
            remain_step_i_1 = remain_step_i;
        }
        return remain_step_i;
    }
}