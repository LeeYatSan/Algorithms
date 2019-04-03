public class Solution {
    public int JumpFloorII(int target) {
        int way[] = new int[target+1];
        way[0] = 1;
        way[1] = 1;
        for(int i = 2; i <= target; ++i)
            way[i] = 2*way[i-1];
        return way[target];
    }
}