public class Main {
    public static void main(String[] args){
        char[] input = {'h','e','l','l','o'};
        Solution s = new Solution();
        s.reverseString(input);
        for(char elem : input)
            System.out.print(elem);
    }
}
