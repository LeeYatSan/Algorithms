import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
            System.out.println(parseIP(in.nextLine()));
    }


    private static String parseIP(String input){
        if(input.contains("."))
            return IPToDecimal(input);
        else
            return DecimalToIP(input);
    }


    private static String IPToDecimal(String ip){
        StringBuilder tmp = new StringBuilder();
        String[] segments = ip.split("\\.");
        for(int i = 0; i < segments.length; ++i){
            int currSegment = Integer.parseInt(segments[i]);
            String currBiStr = Integer.toBinaryString(currSegment);
            for(int j = 0; j < 8-currBiStr.length(); ++j)
                tmp.append("0");
            tmp.append(currBiStr);
        }
        String binaryStr = tmp.toString();
        BigInteger base = new BigInteger("2");
        BigInteger bigIntRes = new BigInteger("0");
        for(int i = 0; i < binaryStr.length(); ++i){
            if(binaryStr.charAt(i) == '1')
                bigIntRes = bigIntRes.add(base.pow(binaryStr.length()-i-1));
        }
        return bigIntRes.toString();
    }

    private static String DecimalToIP(String decimal){
        BigInteger decimalBigInt = new BigInteger(decimal);
        BigInteger base = new BigInteger("2");
        BigInteger zero = new BigInteger("0");
        Stack<Integer> biNum = new Stack<>();
        while(!decimalBigInt.equals(zero)){
            if(!decimalBigInt.mod(base).equals(zero))
                biNum.add(1);
            else
                biNum.add(0);
            decimalBigInt = decimalBigInt.divide(base);
        }
        StringBuilder tmp = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 32-biNum.size(); ++i)
            tmp.append("0");
        while (!biNum.isEmpty())
            tmp.append(biNum.pop().toString());
        String biStr = tmp.toString();

        StringBuilder currSegment = new StringBuilder(biStr.substring(0, 8));
        res.append(Integer.parseInt(currSegment.toString(), 2));
        res.append(".");

        currSegment = new StringBuilder(biStr.substring(8, 16));
        res.append(Integer.parseInt(currSegment.toString(), 2));
        res.append(".");

        currSegment = new StringBuilder(biStr.substring(16, 24));
        res.append(Integer.parseInt(currSegment.toString(), 2));
        res.append(".");

        currSegment = new StringBuilder(biStr.substring(24));
        res.append(Integer.parseInt(currSegment.toString(), 2));
        return res.toString();
    }
}
