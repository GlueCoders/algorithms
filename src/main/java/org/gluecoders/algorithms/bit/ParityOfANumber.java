package org.gluecoders.algorithms.bit;

import java.util.Random;
import java.util.stream.IntStream;

public class ParityOfANumber {

    //Parity of a binary number is 1 if no of 1 bits are odd else it is 0 for even no of 1 bits
    public static void main(String[] args) {
        System.out.println("Parity for 64 bit numbers");
        new Random().longs(10)
                .peek(System.out::println)
                .forEach(x -> System.out.println(parityByAndWithLesserNumber(x)));
        int numberBitSize = 32;
        System.out.println("Building cache for 8 bit number");
        int[] cache = buildParityCache(numberBitSize);
        System.out.println("Parity for 32 bit numbers");
        new Random().ints(100)
                .peek(System.out::println)
                .forEach(x -> System.out.println(parityByCache(x, cache, numberBitSize)));
    }

    private static int parityByCache(int x, int[] cache, int numberBitSize) {
        int cacheUnit = numberBitSize / 4;
        int bitMask = (1 << cacheUnit) - 1;
        int parity = 0;
        parity ^= cache[x & bitMask];
        parity ^= cache[(x >> cacheUnit) & bitMask];
        parity ^= cache[(x >> 2 * cacheUnit) & bitMask];
        parity ^= cache[(x >> 3 * cacheUnit) & bitMask];
        return parity;
    }

    private static int[] buildParityCache(int numberBitSize) {
        int[] cache = new int[(1 << numberBitSize / 4)];
        IntStream.range(0, (1 << (numberBitSize/4)) - 1)
                .forEach(x -> cache[x] = Integer.bitCount(x) & 1);
        return cache;
    }

    // "AND" between num and num-1 will always remove rightmost set bit(bit which is 1)
    public static int parityByAndWithLesserNumber(long num) {
        int total = 0;
        while (num != 0) {
            total++;
            num = num & (num - 1);
        }
        return total & 1 ;
    }
}
