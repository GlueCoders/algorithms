package org.gluecoders.algorithms.bit;

import java.util.Random;

public class BitsReversal {

    public static void main(String[] args) {
        new Random().longs(100)
                .forEach(BitsReversal::reverseBits);
        reverseBits(11);
        System.out.println(Integer.highestOneBit(11));
    }

    private static void reverseBits(long x) {
        System.out.println(" before reverse X "+ x);
        int j = (int) (Math.log(x) / Math.log(2));
        for (int i = 0; i < (j+1)/2; i++) {
            x = SwappingBits.swapBits(x, i, j - i);
        }
        System.out.println(" after reverse X "+ x);
    }
}
