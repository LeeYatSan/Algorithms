import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            ArrayList<Integer> output = new ArrayList<>();
            String[] firstLine = (in.nextLine()).split(" ");
            int stuNum = Integer.parseInt(firstLine[0]);
            int operation = Integer.parseInt(firstLine[1]);
            if(stuNum == 0 || operation == 0)
                return;
            int[] score = new int[stuNum];
            String[] secondLine = (in.nextLine()).split(" ");
            for(int i = 0; i < stuNum; ++i)
                score[i] = Integer.parseInt(secondLine[i]);
            for(int i = 0; i < operation && in.hasNext(); ++i){
                String[] currLine = in.nextLine().split(" ");
                if(currLine.length != 3)
                    continue;
                if(currLine[0].charAt(0) == 'Q')
                    output.add(searchHighestScore(score, Integer.parseInt(currLine[1])-1, Integer.parseInt(currLine[2])-1));
                else if(currLine[0].charAt(0) == 'U')
                    score[Integer.parseInt(currLine[1])-1] = Integer.parseInt(currLine[2]);
            }
            for(int i : output)
                System.out.println(i);
        }
    }
    static int searchHighestScore(int[] score, int A, int B){
        int start, end;
        if(A < B){
            start = A;
            end = B;
        }
        else{
            start = B;
            end = A;
        }
        int max = score[start];
        for(int i = start; i <= end; ++i){
            if(score[i] > max)
                max = score[i];
        }
        return max;
    }
}
