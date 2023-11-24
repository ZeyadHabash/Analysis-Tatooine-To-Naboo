package csen703.main.assignment1;

public class TheBadBatch {

    public static void main(String[] args) {
        int[] fuel1 = {2, 3, 1, 1, 4};
        int[] fuel2 = {3, 2, 1, 0, 4};

        System.out.println("fuel 1");
        System.out.println(TatooineToNabooDivideAndConquer(fuel1)); // Expected: true
        System.out.println(TatooineToNabooGreedy(fuel1)); // Expected: true

        System.out.println("fuel 2");
        System.out.println(TatooineToNabooDivideAndConquer(fuel2)); // Expected: false
        System.out.println(TatooineToNabooGreedy(fuel2)); // Expected: false
    }

    public static boolean TatooineToNabooDivideAndConquer(int[] fuel) {
        return TatooineToNabooDivideAndConquerHelper(fuel, fuel.length - 1);
    }

    public static boolean TatooineToNabooDivideAndConquerHelper(int[] fuel, int
            destination) {
        if (destination == 0) {
            return true;
        }
        for (int i = destination - 1; i >= 0; i--) {
            if (fuel[i] >= destination - i) {
                boolean accepted = TatooineToNabooDivideAndConquerHelper(fuel, i);
                if (accepted) {
                    return true;
                }
            }
        }
        return false;
    }

    // public static boolean TatooineToNabooDivideAndConquer(int[] fuel) {
    // if (fuel[0] >= fuel.length - 1)
    // return true;
    // // divide based on indices of fuel = 0

    // return false;
    // }


    public static boolean TatooineToNabooGreedy(int[] fuel) {
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
