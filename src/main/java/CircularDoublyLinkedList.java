class CircularDoublyLinkedListNode {
    int data;
    CircularDoublyLinkedListNode next;
    CircularDoublyLinkedListNode prev;

    CircularDoublyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CircularDoublyLinkedList {
    CircularDoublyLinkedListNode head;
    public void insert(int data) {

        if (head == null) {
            CircularDoublyLinkedListNode newNode = new CircularDoublyLinkedListNode(data);
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            CircularDoublyLinkedListNode temp;
            temp = head;
            CircularDoublyLinkedListNode newNode = new CircularDoublyLinkedListNode(data);

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void insert(int data, int index) {

       CircularDoublyLinkedListNode newNode = new CircularDoublyLinkedListNode(data);

        if (index == 0) {
            if(head == null) {
                head = newNode;
                head.next = head;
                head.prev = head;
            } else {
                CircularDoublyLinkedListNode temp;
                temp = head;

                while (temp.next != head) {
                    temp = temp.next;
                }

                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else {
            CircularDoublyLinkedListNode temp = head;
            int currindex = 0;

            while (currindex < index - 1 && temp.next != head) {
                temp = temp.next;
                currindex++;
            }

            if (currindex == index -1) {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public void update(int data, int index) {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        } else {
            CircularDoublyLinkedListNode temp = head;
            int currIndex = 0;

            while (temp.next != head && currIndex < index) {
                temp = temp.next;
                currIndex++;
            }

            if (currIndex == index) {
                temp.data = data;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public int getData(int index) {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        } else {
            CircularDoublyLinkedListNode temp = head;
            int currIndex = 0;

            while (temp.next != head && currIndex < index) {
                temp = temp.next;
                currIndex++;
            }

            if (currIndex == index) {
                return temp.data;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public void deleteByIndex(int index) {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        } else {
            if (index == 0) {
               CircularDoublyLinkedListNode temp = head;
               CircularDoublyLinkedListNode delNode;

               while(temp.next != head) {
                   temp = temp.next;
               }

               delNode = head;
               temp.next = head.next;
               head.next.prev = temp;
               head = head.next;
               delNode.next = null;
               delNode.prev = null;
            } else {
                CircularDoublyLinkedListNode temp = head;
                CircularDoublyLinkedListNode delNode;
                int  currIndex = 0;

                while (currIndex < index - 1 && temp.next != head) {
                    temp = temp.next;
                    currIndex++;
                }

                if (currIndex == index -1 && temp.next != head) {
                    delNode = temp.next;
                    temp.next = delNode.next;
                    delNode.next.prev = temp;
                    delNode.next = null;
                    delNode.prev = null;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
        }
    }

    public void deleteByValue(int value) {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        } else {
            if (head.data == value) {
                deleteByIndex(0);
            } else {
                CircularDoublyLinkedListNode temp = head;

                while (temp.next != head && temp.next.data != value) {
                    temp = temp.next;
               }

                if (temp.next != head && temp.next.data == value) {
                    CircularDoublyLinkedListNode delNode;
                    delNode = temp.next;
                    temp.next = delNode.next;
                    delNode.next.prev = temp;
                    delNode.next = null;
                    delNode.prev = null;
                }
            }
        }
    }

    @Override
    public String toString() {

        String output = "[";
        CircularDoublyLinkedListNode temp = head;
        do {
           if (temp.next != head) {
                output = output + temp.data;
                output = output + ", ";
                temp = temp.next;
            } else {
                output = output + temp.data;
                temp = temp.next;
            }
        } while (temp != head);

        output += "]";

        return output;
    }
}


class cPilot{

    public static void main(String[] args) {

        CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();

        circularDoublyLinkedList.insert(5);
        circularDoublyLinkedList.insert(23);
        circularDoublyLinkedList.insert(13);
        System.out.println(circularDoublyLinkedList.toString());

        circularDoublyLinkedList.insert(107, 3);
        circularDoublyLinkedList.insert(79, 1);
        circularDoublyLinkedList.insert(11, 0);
        System.out.println(circularDoublyLinkedList.toString());

        circularDoublyLinkedList.update(45, 0);
        circularDoublyLinkedList.update(100, 5);
        circularDoublyLinkedList.update(22, 3);
//        circularDoublyLinkedList.update(44, 10);
        System.out.println(circularDoublyLinkedList.toString());
////
        circularDoublyLinkedList.deleteByIndex(0);
        System.out.println(circularDoublyLinkedList.toString());
        circularDoublyLinkedList.deleteByIndex(4);
        System.out.println(circularDoublyLinkedList.toString());
////
        circularDoublyLinkedList.deleteByValue(13);
        System.out.println(circularDoublyLinkedList.toString());
//
        circularDoublyLinkedList.deleteByValue(5);
        System.out.println(circularDoublyLinkedList.toString());
////
        System.out.println(circularDoublyLinkedList.getData(0));
    }

}



