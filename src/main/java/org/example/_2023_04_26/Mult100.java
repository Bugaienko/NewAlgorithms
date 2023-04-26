package org.example._2023_04_26;

/**
 * @author Sergii Bugaienko
 */

public class Mult100 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6, 4, 8};
        int k = 100;

        System.out.println(countMultyplier(nums, k));
    }

    private static int countMultyplier(int[] nums, int k) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                counter++;
                System.out.println(nums[i]);
            }

            //TODO Refactor

            if (i < nums.length - 1) {
                if (nums[i] * nums[i + 1] < k) {
                    System.out.println(nums[i] + " " + nums[i + 1]);
                    counter++;
                }
            }
            if (i < nums.length - 2) {
                if (nums[i] * nums[i + 1] * nums[i + 2] < k) {
                    System.out.println(nums[i] + " " + nums[i + 1] + " " + nums[i + 2]);
                    counter++;
                }
            }

        }
        return counter;
    }

}
