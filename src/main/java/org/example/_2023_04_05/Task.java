package org.example._2023_04_05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Bugaienko
 */

public class Task {
    /**
     * int a;
     * 00010010
     */

    public static void main(String[] args) {

        int n = 0b00010010;
        System.out.println(getOne(n));

        int x = -120;
        System.out.println(getReverse(x));
        System.out.println(getReverseByString(x));

        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {

        int length = arr.length + 1;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < length; i++) {
            sum1 += i;
            if (i < length -1){
                sum2 += arr[i];
            }
        }
        return sum1 - sum2;
    }

    private static int getReverse(int x) {
        List<Integer> integers = new ArrayList<>();

        int multyplicator = 1;
        if (x < 0) {
            multyplicator = -1;
            x = x * (-1);
        }

        while (x > 0) {
            integers.add(x % 10);
            x = x / 10;
        }

        int result = 0;
        for (int i = 0; i < integers.size(); i++) {
            result += (int) (integers.get(i) * (Math.pow(10, integers.size() - i - 1)));
        }
        result *= multyplicator;
        return result;
    }

    public static int getReverseByString(int x) {
        int multyplicator = 1;
        if (x < 0) {
            multyplicator = -1;
            x = x * (-1);
        }
        String str = String.valueOf(x);
        char[] characters = str.toCharArray();
        char[] resultChars = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            resultChars[characters.length - i - 1] = characters[i];
        }

        String test = String.valueOf(resultChars);
        int result = Integer.parseInt(test);

        result *= multyplicator;
        return result;
    }

    public static int getOne(int n) {
        int result = 0;

        while (n != 0) {
            n = n & (n - 1);
            result++;
            printBinary(n);

        }
        return result;
    }


    public static void printBinary(int b) {
        System.out.println("0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1));
    }
}
