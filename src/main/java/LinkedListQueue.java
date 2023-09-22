public class LinkedListQueue {
    LinkedListNode front;

    public void enqueue(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (front == null) {
            front = newNode;
        } else {
            LinkedListNode temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int dequeue() {
        if (front != null) {
            LinkedListNode temp = front;
            front = front.next;
            return temp.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int peek() {
        if (front != null) {
            return front.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }



   @Override
    public String toString() {

        String output = "[";
        LinkedListNode temp = front;

        while (temp != null) {

            if (temp.next != null) {
                output = output + temp.data;
                output = output + ", ";
                temp = temp.next;
            } else {
                output = output + temp.data;
                temp = temp.next;
            }
        }
        output += "]";

        return output;
    }
}

class LinkedListQueueRunner {
    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();

        int[] arr = {10, 20, 77, 63, 78, 13};
        for (int i:arr) {
            linkedListQueue.enqueue(i);
        }

        System.out.println(linkedListQueue.toString());

        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());

        System.out.println(linkedListQueue.toString());

        linkedListQueue.enqueue(215);
        System.out.println(linkedListQueue.peek());

        System.out.println(linkedListQueue.toString());
    }
}




























