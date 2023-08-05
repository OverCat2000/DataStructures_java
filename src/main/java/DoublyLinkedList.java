class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    DoublyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {

    DoublyLinkedListNode head;

    public void insert(int data) {

        if (head == null) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            head = newNode;
        } else {
            DoublyLinkedListNode temp = head;
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void insert(int data, int index) {

        if (index == 0) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            DoublyLinkedListNode temp = head;
            int currIndex = 0;

            while (temp != null && currIndex < index - 1) {
                temp = temp.next;
                currIndex++;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    public void update(int data, int index) {

        if (head == null) {
            throw new IndexOutOfBoundsException();
        } else {
            DoublyLinkedListNode temp = head;
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
            DoublyLinkedListNode temp = head;
            int currIndex = 0;

            while (currIndex < index && temp != null) {
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
                DoublyLinkedListNode temp  = head;
                head.next.prev = null;
                head = head.next;
                temp.next = null;
            } else {
                DoublyLinkedListNode temp = head;
                DoublyLinkedListNode delNode;
                int currIndex = 0;

                while (temp.next != null && currIndex < index -1) {
                    temp = temp.next;
                    currIndex++;
                }

                if (currIndex == index - 1 && temp.next != null) {
                    delNode = temp.next;
                    if (delNode.next == null) {
                        temp.next = null;
                        delNode.prev = null;
                    } else {
                        temp.next = delNode.next;
                        delNode.next.prev = temp;
                        delNode.prev = null;
                        delNode.next = null;
                    }
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
                DoublyLinkedListNode temp = head;
                head.next.prev = null;
                head = head.next;
                temp.next = null;
                //deleteByIndex(0);
            } else {
                DoublyLinkedListNode temp = head;
                DoublyLinkedListNode delNode;

                while (temp.next != null && temp.next.data != value) {
                    temp = temp.next;
                }

                if (temp.next != null && temp.next.data == value) {
                    delNode = temp.next;
                    if (delNode.next == null) {
                        temp.next = null;
                        delNode.prev = null;
                    } else {
                        delNode.next.prev = temp;
                        temp.next = delNode.next;
                        delNode.next = null;
                        delNode.prev = null;
                    }
                } else {
                    ;
                }
            }
        }
    }

    @Override
    public String toString() {

        String output = "[";
        DoublyLinkedListNode temp = head;

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

class pilot {

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insert(10);
        doublyLinkedList.insert(34);
        doublyLinkedList.insert(76);
        doublyLinkedList.insert(107);
        doublyLinkedList.insert(89, 2);
        doublyLinkedList.insert(9, 0);
        System.out.println(doublyLinkedList.toString());

        System.out.println(doublyLinkedList.getData(1));
        doublyLinkedList.update(33, 1);
        System.out.println(doublyLinkedList.toString());

        doublyLinkedList.deleteByIndex(0);
        System.out.println(doublyLinkedList.toString());

        doublyLinkedList.deleteByIndex(4);
        System.out.println(doublyLinkedList.toString());

        doublyLinkedList.deleteByValue(76);
        System.out.println(doublyLinkedList.toString());
    }

}























