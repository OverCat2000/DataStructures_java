import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {

    static void Selection(int[] arr) {

        for (int j = 0; j < arr.length - 1; j++) {
            int max = 0;
            int index = 0;

            for (int i = 0; i < arr.length - i; i++) {

                if (max < arr[i]) {
                    max = arr[i];
                    index = i;
                }
                int temp = arr[i];
                arr[i] = max;
                arr[index] = temp;
            }
        }
    }

    static void BubbleSort(int[] arr) {
        for (int j = 0; j < arr.length -1; j++) {
            boolean swap = false;
            for (int i = 0; i < arr.length - 1 - j; i++) {
                int temp = 0;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            //true not right
            while (j > 0 && true) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
            }
            arr[j - 1] = temp;
            System.out.println(Arrays.toString(arr));
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 21, 5, 13, 100, 54};
//        Selection(arr);
//        System.out.println(Arrays.toString(arr));
//        BubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }




}
