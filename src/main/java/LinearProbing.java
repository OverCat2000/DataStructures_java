import java.util.Arrays;
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

        if (arr[index] == value) {
            return true;
        }
        int rehash = (index + 1) % size;
        while (index != rehash) {
            if (arr[rehash] == value) {
                return true;
            }
            rehash = (rehash + 1) % size;
        }
        return false;
    }





    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing(10);
        linearProbing.put(10);
        linearProbing.put(20);
        linearProbing.put(30);
        linearProbing.put(99);
        linearProbing.put(9);
        linearProbing.put(19);
        linearProbing.put(45);
        System.out.println(linearProbing.contains(10));
        System.out.println(linearProbing.contains(20));
        System.out.println(linearProbing.contains(30));
        System.out.println(linearProbing.contains(52));
        System.out.println(Arrays.toString(linearProbing.arr));
    }











}
