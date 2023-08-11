import java.security.spec.RSAOtherPrimeInfo;

public class recursion {

    static int factorial(int n) {
        if (n - 1 > 0) {
            int val = n*factorial(n - 1);
            return val;
        }

        return 1;
    }
    
    static int fibonacci(int n) {
        return 1;
    }

    static void towersOfHanoi(int disks, String source, String aux, String dest) {
        if (disks != 0) {
            towersOfHanoi(disks - 1, source, dest, aux);
            System.out.println("move disk from " + source + " to " + dest);
            towersOfHanoi(disks - 1, aux, source, dest);
        }

    }



    public static void main(String[] args) {
        System.out.println(factorial(5));
        towersOfHanoi(3, "A", "B", "C");
    }
}






