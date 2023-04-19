package org.example._1904_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergii Bugaienko
 */

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, -1, -3, 5, 7};
        int x = 8;
//        System.out.println(Arrays.toString(isPresentSum(array, x)));

        String a = "a#a#ba##ac#";
        String b = "a";


        System.out.println(parseString(a, b));
    }

    public static int[] isPresentSum(int[] arr, int x) {
        List<Integer[]> resultList = new ArrayList<>();
        int[] result = {0, 0, 0, x};
        if (arr.length < 3) {
            return result;
        }
        int temp;
        int delta;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (j < arr.length - 1) {
                        for (int k = j; k < arr.length; k++) {
                            temp = arr[i] + arr[j] + arr[k];
                            delta = x - temp;
                            if (delta == 0) {
                                resultList.add(new Integer[]{arr[i], arr[j], arr[k]});
                            }
                            if (Math.abs(delta) < Math.abs(result[3])) {
                                result[0] = arr[i];
                                result[1] = arr[j];
                                result[2] = arr[k];
                                result[3] = delta;
                            }
                        }
                    }

                }
            }

        }
        if (!resultList.isEmpty()) {
            for (Integer[] arr1 : resultList) {
                System.out.println(Arrays.toString(arr1));
            }
        }
        return result;
    }

    public static boolean parseString(String s, String b) {
        String result = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#') {
                result += chars[i];
            } else {
                if (result.length() > 0) {
                    result = result.substring(0, result.length() - 1);
                }
            }

        }
        return result.equals(b);
    }
}
