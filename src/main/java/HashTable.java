public class HashTable {
    private int[] arr;
    private int size;

    public HashTable(int size) {
        arr = new int[size];
        this.size = size;
    }

    public void put(int value) {
        int index = value % size;
        arr[index] = value;
    }

    public boolean contains(int value) {
        int index = value % size;
        if (arr[index] == value) {
            return true;
        }
        return false;
    }
}

class Hash {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.put(5);
        hashTable.put(11);
        hashTable.put(12);
        System.out.println(hashTable.contains(12));
        System.out.println(hashTable.contains(22));
    }
}






