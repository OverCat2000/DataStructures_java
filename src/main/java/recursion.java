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

    static void fourTowersOfHanoi(int disks, String source, String aux1, String aux2, String dest) {

        if (disks == 1) {
            disks = disks - 1;
            System.out.println("move disk from " + source + " to " + dest + "\n");
        } else if(disks != 0) {
            fourTowersOfHanoi(disks - 2, source, dest, aux2, aux1);
            System.out.println("move disk from " + source + " to " + aux2);
            System.out.println("move disk from " + source + " to " + dest);
            System.out.println("move disk from " + aux2 + " to " + dest + "\n");
            fourTowersOfHanoi(disks - 2, aux1, source, aux2, dest);
        }

    }



    public static void main(String[] args) {
        System.out.println(factorial(5));
//        towersOfHanoi(3, "A", "B", "C");
        fourTowersOfHanoi(5, "A", "B", "C", "D");
    }
}






