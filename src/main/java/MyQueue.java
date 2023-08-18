public class MyQueue {
    int arr[];
    int front;
    int rear;

    public MyQueue(int size) {
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int data) {
        if (!isFull()) {
            if (isEmpty()) {
                front++;
            }
            rear = (rear + 1) % arr.length;
            arr[rear] = data;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int temp = arr[front];
            arr[front] = 0;
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % arr.length;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        if (rear == front - 1) {
            return true;
        } else if (rear == arr.length - 1 && front == 0) {
            return true;
        } else {
            return false;
        }
    }
}







