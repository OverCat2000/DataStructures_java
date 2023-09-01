public class methods {

    static void passByValue(int x) {
        x = 10;
    }

    static void passByReference(int[] x) {
        x[0] = 10;
    }

    public static void main(String[] args) {
        int x1 = 20;
        int[] x2 = {20};
        passByValue(x1);
        passByReference(x2);
        System.out.println(x1);
        System.out.println(x2[0]);
    }
}
