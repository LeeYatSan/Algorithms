import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(int x) {
        //solution1
//        if(x < 0)
//            return false;
//        else if(x == 0)
//            return true;
//        else {
//            int val = x, temp = 0;
//            while(x != 0){
//                temp = temp*10+x%10;
//                if(temp == val)
//                    return true;
//                x/=10;
//            }
//            return false;
//        }

        //solution2
//        if(x < 0)
//            return false;
//        else{
//            ArrayList<Integer> arr = new ArrayList<>();
//            while(x != 0){
//                arr.add(x%10);
//                x/=10;
//            }
//            int i = 0, j = arr.size()-1;
//            while(j>i && i<arr.size() && j>0){
//                if(arr.get(i++) != arr.get(j--))
//                    return false;
//            }
//            return true;
//        }

        //solution3
        if(x < 0 || (x!=0 && x%10==0))
            return false;
        else {
            int temp = 0;
            while(x > temp){
                temp = temp*10+x%10;
                x/=10;
            }
            if(x==temp || temp/10 == x)
                return true;
            else
                return false;
        }
    }
}