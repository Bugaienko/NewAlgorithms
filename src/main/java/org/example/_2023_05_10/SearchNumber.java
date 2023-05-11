package org.example._2023_05_10;

import java.util.Arrays;

/**
 * @author Sergii Bugaienko
 */

public class SearchNumber {
    private static int x;
    private static int y;
    private static int[][] array =
                    {{1, 4, 7, 11, 15, 16},
                    {2, 5, 8, 12, 19, 21},
                    {3, 6, 9, 16, 22, 24},
                    {10, 13, 14, 17, 24, 27},
                    {18, 21, 23, 26, 30, 36}};

    public static void main(String[] args) {
        int searchingNumber = 14;
//        System.out.println(Arrays.toString(searchNumber(searchingNumber)));

        int[][] A = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        System.out.println(Arrays.deepToString(A));
        rotateMatrix(A);
    }

    private static int[] searchNumber(int searchingNumber) {
        x = 0;
        y = array[0].length - 1;
//        System.out.println(x + " " + y);
        int[] result = {-1, -1};
        while (x < array.length && y >= 0) {
            if (array[x][y] == searchingNumber) {
                result[0] = x;
                result[1] = y;
                System.out.println(array[x][y]);
                return result;
            } else {
                createMove(searchingNumber);
            }
        }
        return result;
    }

    private static void createMove(int searchingNumber) {
        System.out.println(x + " " + y);
        if (y > 0 && array[x][y] > searchingNumber) {
            y--;
            return;
        } else if (x < array.length - 1 && array[x +1][y] <= searchingNumber) {
                x++;
            }
        else {
            System.out.println(y);
            y--;
        }
    }

    private static void rotateMatrix(int[][] array) {
        int len = array.length;
        int[][] newMatrix =new int[array.length][array[0].length];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                newMatrix[(len - 1) -j ][i] = array[i][j];
            }
        }
        System.out.println(Arrays.deepToString(newMatrix));
    }
}
