package csen703.main.assignment2;

import java.util.ArrayList;

public class TheBadBatchPath {

    public static void main(String[] args) {
        System.out.println("The Bad Batch Path");

        int[] fuel1 = {3, 2, 5, 1, 2, 0, 1};
        int[] fuel2 = {1, 0, 2};

        System.out.println("fuel 1");
        System.out.println(TatooineToNabooDP(fuel1)); // Expected: 2
        System.out.println(TatooineToNabooPath(fuel1)); // Expected: [0, 1, 4]

        System.out.println("fuel 2");
        System.out.println(TatooineToNabooDP(fuel2)); // Expected: 0
        System.out.println(TatooineToNabooPath(fuel2)); // Expected: []
    }

    public static Integer TatooineToNabooDP(int[] fuel) {
        return TatooineToNabooJumps(fuel)[0][0];
    }

    public static ArrayList<Integer> TatooineToNabooPath(int[] fuel) {
        Integer[] source = TatooineToNabooJumps(fuel)[1];

        ArrayList<Integer> path = new ArrayList<Integer>();

        int i = 0;
        while (source[i] != 0){
            path.add(i);
            i = source[i];
        }
        if (i == fuel.length - 1)
            path.add(i);

        return path;
    }
}
