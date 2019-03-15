//[Failed: Unaccepted]
//class Solution {
//    public int brokenCalc(int X, int Y) {
//        if(X == 0 || Y == 0)
//            return 0;
//        int count = 0;
//        if(X > Y)
//            count = X-Y;
//        else if(X < Y){
//            if(X < Y/2){
//                X *= 2;
//                ++count;
//                count += brokenCalc(X, Y);
//            }
//            else if(X*2-Y > X-Y/2-1)
//                count += X-Y/2+1;
//            else
//                count += X*2-Y+1;
//        }
//        return count;
//    }
//}


class Solution {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y%2 == 1)
                Y++;
            else
                Y /= 2;
        }
        return ans + X - Y;
    }
}
