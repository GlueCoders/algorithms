package org.gluecoders.algorithms.bit;

import java.util.Random;
import java.util.stream.LongStream;

public class SwappingBits {

    public static void main(String[] args) {
        new Random().longs(100)
                .forEach(x-> swapBits(x, 5 ,20));
    }

    public static long swapBits(long num, int i, int j) {
        if (((num >> i) & 1) != ((num >> j) & 1)) {
            long bitMask = (1 << i) | (1 << j);
            num ^= bitMask;
        }
        return num;
    }
}
