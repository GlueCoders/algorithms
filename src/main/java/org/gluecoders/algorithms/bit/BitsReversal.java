package org.gluecoders.algorithms.bit;

import java.util.Random;

public class BitsReversal {

    public static void main(String[] args) {
        new Random().longs(100)
                .forEach(BitsReversal::reverseBits);
        reverseBits(11);
        System.out.println(Integer.highestOneBit(11));
    }

    private static void reverseBits(long num) {
        int j = (int) (Math.log(num) / Math.log(2));
        for (int i = 0; i < (j+1)/2; i++) {
            num = SwappingBits.swapBits(num, i, j - i);
        }
    }
}
