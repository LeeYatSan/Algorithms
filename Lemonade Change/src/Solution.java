//solution1
class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0)
            return false;
        else{
            int five_dollor = 0, ten_dollor = 0;
            for(int bill : bills){
                switch (bill){
                    case 5: ++five_dollor; break;
                    case 10: {
                        ++ten_dollor;
                        if(five_dollor > 0)
                            --five_dollor;
                        else
                            return false;
                        break;}
                    case 20: {
                        if(five_dollor > 0 && ten_dollor > 0){
                            --five_dollor;
                            --ten_dollor;
                        }
                        else if(five_dollor/3 > 0)
                            five_dollor -= 3;
                        else
                            return false;
                        break;}
                }
            }
            return true;
        }
    }
}