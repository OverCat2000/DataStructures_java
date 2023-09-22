import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
//    Queue<Integer> q3 = new LinkedList<>();

    public void push(int data) {
        q1.add(data);
    }
    public int pop() {
        int temp;
        while (!q1.isEmpty()) {
            temp = q1.remove();
            if (q1.isEmpty()) {
//                q3 = q2;
//                q2 = q1;
//                q1 = q3;
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
                return temp;
            } else {
                q2.add(temp);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public int peek() {
        int temp;
        while (!q1.isEmpty()) {
            temp = q1.remove();
            q2.add(temp);
            if (q1.peek() == null) {
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
                return temp;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}

class TwoQueueStackRunner {
    public static void main(String[] args) {

        TwoQueueStack twoQueueStack = new TwoQueueStack();

        twoQueueStack.push(2);
        twoQueueStack.push(10);
        twoQueueStack.push(13);
        twoQueueStack.push(72);

        System.out.println(twoQueueStack.q1);

        System.out.println(twoQueueStack.pop());

        System.out.println(twoQueueStack.q1);

        System.out.println(twoQueueStack.pop());

        twoQueueStack.push(9);
        twoQueueStack.push(88);

        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());
        System.out.println(twoQueueStack.pop());

        System.out.println(twoQueueStack.peek());

        System.out.println(twoQueueStack.pop());
//        System.out.println(twoQueueStack.peek());


    }
}







