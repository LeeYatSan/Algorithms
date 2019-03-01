////Solution1
//import java.util.ArrayList;
//
//class MinStack {
//
//    ArrayList<Integer> elems = new ArrayList<>();
//
//    public MinStack() {}
//
//    public void push(int x) {
//        elems.add(x);
//    }
//
//    public void pop() {
//        elems.remove(elems.size()-1);
//    }
//
//    public int top() {
//        return elems.get(elems.size()-1);
//    }
//
//    public int getMin() {
//        if(!elems.isEmpty()){
//            int min = elems.get(0);
//            for(int elem : elems)
//                min = Math.min(min, elem);
//            return min;
//        }
//        else return 0;
//    }
//}

////Solution2: each time when push element into the array, put two elements, the former is the pushed element itself, the latter is current min element. Also, each time when pop the elements, pop out 2 elements each time.
//import java.util.Stack;
//
//class MinStack {
//
//    Stack<Integer> elems = new Stack<>();
//
//    public MinStack() {}
//
//    public void push(int x) {
//        if(!elems.isEmpty()){
//            int currMin = elems.peek();
//            elems.push(x);
//            elems.push(Math.min(currMin, x));
//        }
//        else{
//            elems.push(x);
//            elems.push(x);
//        }
//    }
//
//    public void pop() {
//        if(!elems.isEmpty()){
//            elems.pop();
//            elems.pop();
//        }
//    }
//
//    public int top() {
//        return elems.get(elems.size()-2);
//    }
//
//    public int getMin() {
//        return elems.peek();
//    }
//}


//Solution3: Use two stack
import java.util.Stack;

class MinStack {

    Stack<Integer> elems = new Stack<>();
    Stack<Integer> mins = new Stack<>();

    public MinStack() {}

    public void push(int x) {
        if(!elems.isEmpty()){
            elems.push(x);
            mins.push(Math.min(mins.peek(), x));
        }
        else{
            elems.push(x);
            mins.push(x);
        }
    }

    public void pop() {
        if(!elems.isEmpty()){
            elems.pop();
            mins.pop();
        }
    }

    public int top() {
        return elems.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}