package org.example._2023_04_26;

import java.util.Arrays;

/**
 * @author Sergii Bugaienko
 */

public class Chess {


    public static void main(String[] args) {
        int[] k = {2, 3};
        int[][] q = {{4, 5}, {3, 3}, {2, 4}, {6, 3}, {5, 7}, {5, 6}, {7, 8}, {1, 2}};
        isQueenIsQueen(k, q);
    }

    public static void isQueenIsQueen(int[] k, int[][] q) {



        for (int j = 0; j < q.length; j++) {
            if (k[0] == q[j][0]) {
                System.out.println("Beat!");
                System.out.println(Arrays.toString(q[j]));
                continue;
            }
            if (k[1] == q[j][1]) {
                System.out.println("Beat 2!");
                System.out.println(Arrays.toString(q[j]));
                continue;
            }
            for (int i = k[0] + 1; i < 9; i++) {
                if (q[j][0] == i && q[j][1] == k[1] + i - k[0]) {
                    System.out.println("diagonal");
                    System.out.println(Arrays.toString(q[j]));

                }
            }
            for (int i = 0; i < k[0] + 1; i++) {
                if (q[j][0] == i && q[j][1] == k[1] + i - k[0]) {
                    System.out.println("diagonal");
                    System.out.println(Arrays.toString(q[j]));

                }
            }


        }

    }

}
