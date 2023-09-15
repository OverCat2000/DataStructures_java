import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;

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

    static void MergeSort(int[] arr) {
        MergeSortImp(arr, 0, arr.length - 1);
    }

    static void MergeSortImp(int[] arr, int start, int end) {
        if (start != end) {
            int mid = (start + end) / 2;
            MergeSortImp(arr, start, mid);
            MergeSortImp(arr, mid + 1, end);
            Merge(arr, start, mid, end);
        }
    }

    static void Merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= end) {

            if (arr[left] > arr[right]) {
                temp[index] = arr[right];
                right++;
                index++;
            } else if (arr[left] < arr[right]) {
                temp[index] = arr[left];
                left++;
                index++;
            }
        }

        while (left <= mid) {
            temp[index] = arr[left];
            index++;
            left++;
        }

        while (right <= end) {
            temp[index] = arr[right];
            index++;
            right++;
        }
        for (int i = start; i < end + 1; i++) {
            arr[i] = temp[i - start];
        }
    }

    static void QuickSort(int[] arr) {
        QuickSortImp(arr, 0, arr.length - 1, arr.length - 1);
    }

    static void QuickSortImp(int[] arr, int start, int pivot, int end) {
            if (start < end) {
                pivot = partition(arr, start, pivot);
                QuickSortImp(arr, start, pivot - 1, pivot - 1);
                QuickSortImp(arr, pivot + 1, end, end);
            }
    }

    static int partition(int[] arr, int start, int pivot) {
        int index = start;
        int swap = start;
        int temp = 0;

        while(index < pivot) {
            if (arr[index] < arr[pivot]) {
                temp = arr[index];
                arr[index] = arr[swap];
                arr[swap] = temp;
                swap++;
            }
            index++;
        }
        temp = arr[swap];
        arr[swap] = arr[pivot];
        arr[pivot] = temp;
        return swap;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{12, 60, 5, 13, 100, 54, 1, 42};
        int[] brr = new int[]{12, 11};
//        Selection(arr);
//        System.out.println(Arrays.toString(arr));
//        BubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        InsertionSort(arr);
//        System.out.println(Arrays.toString(arr));
//        MergeSort(arr);
//        System.out.println(Arrays.toString(arr))
        QuickSort(arr);
//        partition(brr, 0, brr.length - 1);
        System.out.println(Arrays.toString(arr));
    }




}
