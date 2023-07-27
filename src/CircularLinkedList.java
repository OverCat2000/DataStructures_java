class CircularLinkedListNode {
    int data;
    CircularLinkedListNode next;

    CircularLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    CircularLinkedListNode head;
    public void insert(int data) {

        if (head == null) {
            CircularLinkedListNode newNode = new CircularLinkedListNode(data);
            head = newNode;
            head.next = head;
        } else {
            CircularLinkedListNode temp;
            temp = head;
            CircularLinkedListNode newNode = new CircularLinkedListNode(data);

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void insert(int data, int index) {

       CircularLinkedListNode newNode = new CircularLinkedListNode(data);

        if (index == 0) {
            if(head == null) {
                head = newNode;
                newNode.next = head;
            } else {
                CircularLinkedListNode temp;
                temp = head;

                while (temp.next != head) {
                    temp = temp.next;
                }

                temp.next = newNode;
                newNode.next = head;
                head = newNode;
            }
        } else {
            CircularLinkedListNode temp = head;
            int currindex = 0;

            while (currindex < index - 1 && temp.next != head) {
                temp = temp.next;
                currindex++;
            }

            if (currindex == index -1 ) {
                newNode.next = temp.next;
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
            CircularLinkedListNode temp = head;
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
            CircularLinkedListNode temp = head;
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
               CircularLinkedListNode temp = head;
               CircularLinkedListNode delNode;

               while(temp.next != head) {
                   temp = temp.next;
               }

               delNode = head;
               temp.next = head.next;
               head = head.next;
               delNode.next = null;
            } else {
                CircularLinkedListNode temp = head;
                CircularLinkedListNode delNode;
                int  currIndex = 0;

                while (currIndex < index - 1 && temp.next != head) {
                    temp = temp.next;
                    currIndex++;
                }

                if (currIndex == index -1 && temp.next != head  ) {
                    delNode = temp.next;
                    temp.next = delNode.next;
                    delNode.next = null;
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
                CircularLinkedListNode temp = head;

                while (temp.next != head && temp.next.data != value) {
                    temp = temp.next;
               }

                if (temp.next != head && temp.next.data == value) {
                    CircularLinkedListNode delNode;
                    delNode = temp.next;
                    temp.next = delNode.next;
                    delNode.next = null;
                }
            }
        }
    }

    @Override
    public String toString() {

        String output = "[";
        CircularLinkedListNode temp = head;
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


class cDriver{

    public static void main(String[] args) {

        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.insert(5);
        circularLinkedList.insert(23);
        circularLinkedList.insert(13);
        System.out.println(circularLinkedList.toString());

        circularLinkedList.insert(107, 3);
        circularLinkedList.insert(79, 1);
        circularLinkedList.insert(11, 0);
        System.out.println(circularLinkedList.toString());

        circularLinkedList.update(45, 0);
        circularLinkedList.update(100, 5);
        circularLinkedList.update(22, 3);
        //circularLinkedList.update(44, 10);
        System.out.println(circularLinkedList.toString());
//
        circularLinkedList.deleteByIndex(0);
        System.out.println(circularLinkedList.toString());
        circularLinkedList.deleteByIndex(4);
        System.out.println(circularLinkedList.toString());

//
        circularLinkedList.deleteByValue(22);
        System.out.println(circularLinkedList.toString());

        circularLinkedList.deleteByValue(5);
        System.out.println(circularLinkedList.toString());
//
        System.out.println(circularLinkedList.getData(0));
    }

}




