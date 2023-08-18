import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public TwoQueueStack(Queue<Integer> q1, Queue<Integer> q2) {

    }
    public void push(int data) {
        q1.add(data);
    }
    public int pop() {
        int temp = 0;
        while (q1.peek() != null) {
            temp = q1.remove();

            if(q1.peek() != null) {
                q2.add(temp);
            }
        }
//        System.out.println(q1);
//        System.out.println(q2);
        return temp;

    }
}

class TwoQueueStackRunner {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        TwoQueueStack twoQueueStack = new TwoQueueStack(q1, q2);

        twoQueueStack.push(2);
        twoQueueStack.push(10);
        twoQueueStack.push(13);
        twoQueueStack.push(72);

        System.out.println((twoQueueStack.q1));

        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());

    }
}







