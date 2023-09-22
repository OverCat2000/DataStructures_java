
public class LinkedListStack {
//    java.util.LinkedList linkedList = new LinkedList();
    LinkedListNode top;
    public void push(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (top == null) {
            top = newNode;
        } else {
            LinkedListNode temp = top;
            top = newNode;
            top.next = temp;
        }
    }

    public int pop() {
        if (top != null) {
            LinkedListNode temp = top;
            top = top.next;
            return temp.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int peek() {
        if (top != null) {
            return top.data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {

        String output = "[";
        LinkedListNode temp = top;

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

class LinkedListStackRunner {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();

        int[] arr = {10, 20, 77, 63, 78, 13};
        for (int i:arr) {
            linkedListStack.push(i);
        }

        System.out.println(linkedListStack.toString());

        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());

        System.out.println(linkedListStack.toString());

        linkedListStack.push(215);
        System.out.println(linkedListStack.peek());

        System.out.println(linkedListStack.toString());



    }
}














