import com.sun.tools.javac.util.ArrayUtils;

public class Main {
    public static void main(String[] args){
//        Character[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
//        Character[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};
        Character[] X = str2Character("MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD");
        Character[] Y = str2Character("MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG");

        long startTime = System.nanoTime();
        (new LCS<Character>(X, Y)).LCSLength();
        long endTime = System.nanoTime();
        System.out.println("\nExecuting time: " + (endTime-startTime));
    }

    private static Character[] str2Character(String input){
        return input.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
    }
}
