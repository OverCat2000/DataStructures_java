import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();
        List<Integer> high = new ArrayList<Integer>();
        List<Integer> low = new ArrayList<Integer>();

        for (int i = 0; i < a.size(); i++) {
            int val = a.get(i) + ((!A.isEmpty()) ? A.get(i - 1) : 0);

            if (val > maxSum) {
                break;
            } else {
                A.add(val);
            }
        }

        for (int i = 0; i < b.size(); i++) {
            int val = b.get(i) + ((!B.isEmpty()) ? B.get(i - 1) : 0);

            if (val > maxSum) {
                break;
            } else {
                B.add(val);
            }
        }

        if (A.size() > B.size()) {
            high = A;
            low = B;
        } else {
            high = B;
            low = A;
        }


        int max = 0;
        int maxmax = 0;

        for (int i = 0; i < low.size(); i++) {
            for (int j = 0; j < low.size() - i; j++) {
                if (low.get(low.size() - 1 - j) + high.get(high.size() - 1 - i) <= maxSum) {
                    max = low.size() - j + high.size() - i;
                    break;
                }
            }
            if (max > maxmax) {
                maxmax = max;
            }
        }

        if (high.size() > maxmax) {
            maxmax = high.size();
        }

        return maxmax;
    }

}

public class twoStack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int maxSum = Integer.parseInt(firstMultipleInput[2]);

            String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aTemp[i]);
                a.add(aItem);
            }

            String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int bItem = Integer.parseInt(bTemp[i]);
                b.add(bItem);
            }

            int result = Result.twoStacks(maxSum, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
