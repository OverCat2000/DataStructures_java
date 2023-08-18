public class Queue {

    int[] arr;
    int front;
    int rear;

    public Queue(int size) {
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int item) {
        if (!isFull()) {
            if (isEmpty()) {
                front++;
            }
            rear = (rear + 1) % arr.length;
            arr[rear] = item;
        } else {
            throw new IndexOutOfBoundsException(-1);
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
            throw new IndexOutOfBoundsException(-1);
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear == arr.length - 1 && front == 0) || (rear + 1 == front);
    }
    
}
