package org.gluecoders.algorithms.bit;

import java.util.Random;
import java.util.stream.LongStream;

public class SwappingBits {

    public static void main(String[] args) {
        new Random().longs(100)
                .forEach(x-> swapBits(x, 5 ,20));
    }

    public static long swapBits(long x, int i, int j) {
       // System.out.println("Before swap X "+ x);
        if (((x >> i) & 1) != ((x >> j) & 1)) {
            long bitMask = (1 << i) | (1 << j);
            x ^= bitMask;
        }
      //  System.out.println("After swap X "+ x);
        return x;
    }
}
