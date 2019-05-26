import java.util.Random;

public class Main {
    public static void main(String[] args){

        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(123,1);
        priorityQueue.insert(457,2);
        priorityQueue.insert(669,3);
        priorityQueue.insert(996,4);
        priorityQueue.insert(-1,5);
        System.out.println(priorityQueue.getMax());//-1
        System.out.println(priorityQueue.extractMax());//-1
        System.out.println(priorityQueue.getMax());//996
        Elem temp = priorityQueue.get(1);
        priorityQueue.increaseKey(temp, 6);
        System.out.println(priorityQueue.getMax());//457
    }
}
