package org.gluecoders.algorithms.bit;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PowersOfTwo {

    private static long[] powerOfTwos = new long[64];
    static {
        IntStream.range(0, 64)
                .forEach(x -> powerOfTwos[x] = 1L << x);
    }

    public static void main(String[] args) {
        Arrays.stream(powerOfTwos)
                .forEach(System.out::println);
    }


    public static long[] getPowerOfTwos() {
        return powerOfTwos;
    }



}
