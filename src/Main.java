class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

}

class LinkedList {
    LinkedListNode head;

    public void insert(int data) {

        if (head == null) {
            LinkedListNode newNode = new LinkedListNode(data);
            head = newNode;
        } else {
            LinkedListNode temp;
            temp = head;
            LinkedListNode newNode = new LinkedListNode(data);

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public void insert(int data, int index) {

       LinkedListNode newNode = new LinkedListNode(data);

        if (index == 0) {
            if(head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        } else {
            LinkedListNode temp = head;
            int currindex = 0;

            while (currindex < index - 1 && temp != null) {
                temp = temp.next;
                currindex++;
            }

            if (currindex == index -1 && temp != null) {
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
            LinkedListNode temp = head;
            int currIndex = 0;

            while (temp != null && currIndex < index) {
                temp = temp.next;
                currIndex++;
            }

            if (currIndex == index && temp != null) {
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
            LinkedListNode temp = head;
            int currIndex = 0;

            while (temp != null && currIndex < index) {
                temp = temp.next;
                currIndex++;
            }

            if (currIndex == index && temp != null) {
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
               LinkedListNode temp = head;
               head = head.next;
               temp.next = null;
            } else {
                LinkedListNode temp = head;
                LinkedListNode delNode;
                int  currIndex = 0;

                while (currIndex < index - 1 && temp.next != null) {
                    temp = temp.next;
                    currIndex++;
                }

                if (currIndex == index -1 && temp.next != null) {
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
                LinkedListNode temp = head;

                while (temp.next != null && temp.next.data != value) {
                    temp = temp.next;
               }

                if (temp.next != null && temp.next.data == value) {
                    LinkedListNode delNode;
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
        LinkedListNode temp = head;

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


class driver {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insert(5);
        linkedList.insert(23);
        linkedList.insert(13, 1);
        System.out.println(linkedList.toString());

        linkedList.update(45, 0);
        System.out.println(linkedList.toString());

        linkedList.insert(113);
        linkedList.insert(76);
        System.out.println(linkedList.toString());

        linkedList.deleteByIndex(3);
        //linkedList.insert(45, 20);
        System.out.println(linkedList.toString());

        linkedList.deleteByValue(78);
        System.out.println(linkedList.toString());

        linkedList.deleteByValue(76);
        System.out.println(linkedList.toString());

        System.out.println(linkedList.getData(1));
    }

}


































