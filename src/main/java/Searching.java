public class Searching {
    public static int linearSearch(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] arr, int item) {
        int end = arr.length - 1;
        int start = 0;

        while (start <= end) {
            int mid = (start + end)/2;
            if (item == arr[mid]) {
                return mid;
            } else if(item > arr[mid]) {
                start = mid + 1;
            } else if(item < arr[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {21, 25, 13, 42, 54};
        System.out.println(linearSearch(arr, 13));

        int[] binArr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println(BinarySearch(binArr, 912));

    }
}
