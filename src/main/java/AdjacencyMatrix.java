import java.util.Arrays;
import java.util.Stack;

class ArrStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int[] arr;
    int top;

    public ArrStack(int size) {
        this.arr = new int[size];
        this.top = -1;
    }

    public void transfer() {
        while (!s1.isEmpty()) {
            int temp = s1.pop();
            arr[++top] = temp;
        }

        while (top != -1) {
            s2.push(arr[top--]);
        }

    }

}

public class AdjacencyMatrix {


    public static void main(String[] args) {
        int[][] arr = { {0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0}};

//        System.out.println(Arrays.toString(adjMatrix));
        int[] nodes = new int[7];
        int[] row = new int[7];

        for (int i = 0; i < arr.length; i++ ) {
            for (int j = 0; j < arr[i].length; j++) {
                nodes[j] = nodes[j] + arr[i][j];
                row[i] = row[i] + arr[i][j];
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 6 && row[i] == 0) {
                System.out.println(i + 1);
            }
        }

        ArrStack arrStack = new ArrStack(10);

        int[] data = {1, 2, 3, 4, 5};

        for (int i = 0; i < data.length; i++) {
            arrStack.s1.push(data[i]);
        }

        System.out.println(arrStack.s1);
        System.out.println(arrStack.s2);

        arrStack.transfer();

        System.out.println(arrStack.s2);
    }

}














