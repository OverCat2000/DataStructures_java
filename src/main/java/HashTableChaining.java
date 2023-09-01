import java.util.LinkedList;

public class HashTableChaining {
    private java.util.LinkedList[] arr;
    private int size;

    public HashTableChaining(int size) {
        arr = new LinkedList[size];
        this.size = size;
    }

    public void put(int value) {
        int index = value % size;

        if (arr[index] == null) {
            arr[index] = new java.util.LinkedList<Integer>();
        }

        arr[index].add(value);
    }

    public boolean contain(int value) {
        int index = value % size;

        int j = arr[index].size();

        for (int i = 0; i < j; i++) {
            if (arr[index].get(i).equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashTableChaining hashTableChaining = new HashTableChaining(10);
        hashTableChaining.put(10);
        hashTableChaining.put(11);
        hashTableChaining.put(21);
        System.out.println(hashTableChaining.contain(21));
        System.out.println(hashTableChaining.contain(11));
    }






}
