package org.gluecoders.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortDemo {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> nums = IntStream.range(0,10)
                .map(x -> random.nextInt(10))
                .boxed()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(nums);
        int[] input = new int[nums.size()];
        for(int i = 0; i < input.length ; i++){
            input[i] = nums.get(i);
        }
        InsertionSort.sort(input);
        Arrays.stream(input).forEach(x-> System.out.print("\t"+x));

    }
}
