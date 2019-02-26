import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        if(commands.length == 0)
            return 0;
        else {
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            int curr_x = 0, curr_y = 0, di = 0;//0->N. 1->E. 2->S. 3->W.
            Set<Long>obstacleSet = new HashSet<>();
            for(int[] obstacle : obstacles){
                long ox = (long)obstacle[0] + 30000;
                long oy = (long)obstacle[1] + 30000;
                obstacleSet.add((ox << 16)+oy);
            }
            int res = 0;
            for(int cmd : commands){
                if(cmd == -1)
                    di = (di+1)%4;
                else if(cmd == -2)
                    di = (di+3)%4;
                else {
                    for(int i = 0; i < cmd; ++i){
                        int temp_x = curr_x+dx[di];
                        int temp_y = curr_y+dy[di];
                        long code = (((long) temp_x + 30000) << 16) + ((long) temp_y + 30000);
                        if(!obstacleSet.contains(code)){
                            curr_x = temp_x;
                            curr_y = temp_y;
                            res = Math.max(res, curr_x*curr_x + curr_y*curr_y);
                        }
                        else break;
                    }
                }
            }
            return res;
        }
    }
}