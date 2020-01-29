package org.gluecoders.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InsertionSort {

    public static void sort(int[] nums) {
        printHeaders(nums);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int x = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = x;
                printChange(i, j, nums);
            }
        }
    }

    private static void printHeaders(int[] nums) {
        System.out.print("i\tj");
        IntStream.range(0, nums.length)
                .forEach(x -> System.out.print("\t" + x));
        System.out.println();
        System.out.print("\t");
        Arrays.stream(nums).forEach(x -> System.out.print("\t" + x));
        System.out.println();
    }

    private static void printChange(int i, int j, int[] nums) {
        System.out.print("\033[0;31m"+i + "\t" + j);
        Arrays.stream(nums).forEach(x -> System.out.print("\t" + x));
        System.out.println();
    }

}
