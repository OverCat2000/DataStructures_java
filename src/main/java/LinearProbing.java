import java.util.LinkedList;

public class LinearProbing {
    private int[] arr;
    private int size;

    public LinearProbing(int size) {
        arr = new int[size];
        this.size = size;
    }

    public void put(int value) {
        int index = value % size;
        if (arr[index] == 0) {
            arr[index] = value;
        } else {
            int rehash = (index + 1) % size;
            while (index != rehash) {
                if (arr[rehash] == 0) {
                    arr[rehash] = value;
                    break;
                }
                rehash = (rehash + 1) % size;
            }
        }

    }

    public boolean contains(int value) {
        int index = value % size;

    }





    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing(10);
        linearProbing.put(10);
        linearProbing.put(20);
        linearProbing.put(30);
    }











}
