import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;

class SortingAlpha {

    static void SelectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
    }

    static void BubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    static void InsertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1];
            int index = i;
            while (index >= 0 && temp < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
//            index = index + 1;
            arr[++index] = temp;
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
        int[] arr = new int[]{78, 100, 11, 4, 22, 15, 98};
        int[] brr = new int[]{12, 11};
//        SelectionSort(arr);
//        System.out.println(Arrays.toString(arr));
        BubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
//        InsertionSort(arr);
//        System.out.println(Arrays.toString(arr));
//        MergeSort(arr);
//        System.out.println(Arrays.toString(arr))
//        QuickSort(arr);
//        partition(brr, 0, brr.length - 1);
        System.out.println(Arrays.toString(arr));
    }




}
