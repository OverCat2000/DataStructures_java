import java.util.Stack;

public class TwoStackQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data) {
        s1.push(data);
    }

    public int dequeue() {
        int temp;
        while (!s1.isEmpty()) {
            temp = s1.pop();
            if (s1.isEmpty()) {

                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                return temp;
            } else {
                s2.push(temp);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public int peek() {
        int temp;
        while (!s1.isEmpty()) {
            temp = s1.pop();
            s2.push(temp);
            if (s1.isEmpty()) {

                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                return temp;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}

class twoStackQueueRunner {
    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();

        twoStackQueue.enqueue(10);
        twoStackQueue.enqueue(22);
        twoStackQueue.enqueue(75);
        twoStackQueue.enqueue(23);
        twoStackQueue.enqueue(9);

        System.out.println(twoStackQueue.s1);

        System.out.println(twoStackQueue.dequeue());
        System.out.println(twoStackQueue.dequeue());
        System.out.println(twoStackQueue.dequeue());

        System.out.println(twoStackQueue.s1);

        twoStackQueue.enqueue(77);
        twoStackQueue.enqueue(52);

        System.out.println(twoStackQueue.s1);

        System.out.println(twoStackQueue.peek());

        System.out.println(twoStackQueue.s1);




    }
}











