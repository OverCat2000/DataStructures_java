import java.util.Arrays;

public class FullBST {
    public static void ArrangeImp(int[] arr, int start, int end, BinarySearchTree binarySearchTree) {
        if (start < end) {
            int mid = (end + start) / 2;
            if (mid % 2 == 0) {
                mid++;
            }
            binarySearchTree.insert(arr[mid]);
            ArrangeImp(arr, start, mid - 1, binarySearchTree);
            ArrangeImp(arr, mid + 1, end, binarySearchTree);
        } else {
            binarySearchTree.insert(arr[start]);
        }
    }

    public static void Arrange(int[] arr, BinarySearchTree binarySearchTree) {
        ArrangeImp(arr, 0, arr.length - 1, binarySearchTree);
    }
}

class FullBSTRunner {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6};
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        FullBST.Arrange(arr, binarySearchTree);
        binarySearchTree.treePrint();
    }
}
