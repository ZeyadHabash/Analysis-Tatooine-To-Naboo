package csen703.main.assignment1;

public class TheBadBatch {

    public static void main(String[] args) {
        int[] fuel1 = {2, 3, 1, 1, 4};
        int[] fuel2 = {1,0,2};


        System.out.println("fuel 1");
        System.out.println(TatooineToNabooDivideAndConquer(fuel1)); // Expected: true
        System.out.println(TatooineToNabooGreedy(fuel1)); // Expected: true

        System.out.println("fuel 2");
        System.out.println(TatooineToNabooDivideAndConquer(fuel2)); // Expected: false
        System.out.println(TatooineToNabooGreedy(fuel2)); // Expected: false
    }

    public static boolean TatooineToNabooDivideAndConquer(int[] fuel) {
        return TatooineToNabooDivideAndConquerHelper(fuel, 0);
    }

    public static boolean TatooineToNabooDivideAndConquerHelper(int[] fuel, int start) {
        if (start >= fuel.length - 1) {
            return true;
        }
        if (fuel[start] == 0) {
            return false;
        }
        for (int i = start + 1; i <= start + fuel[start]; i++) {
            if (i >= fuel.length - 1) {
                return true;
            }
            if (fuel[i] == 0) {
                continue;
            }
            if (TatooineToNabooDivideAndConquerHelper(fuel, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean TatooineToNabooGreedy(int[] fuel) {
        if (fuel.length <= 1)
            return true;
        if (fuel[0] == 0)
            return false;

        int currentFuel = fuel[0];

        for (int i = 0; i < fuel.length - 2; i++) {
            currentFuel--;
            if (currentFuel < fuel[i + 1]) {
                currentFuel = fuel[i + 1];
            }
            if (currentFuel == 0) {
                return false;
            }
        }
        return true;
    }

}
