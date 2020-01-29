package org.gluecoders.algorithms.bit;

public class ClosestIntSameBitCount {

    public static void main(String[] args) {
        long x = 13;
        for (int i = 0; i < 64; i++) {
            if ((x >> i & 1) != (x >> (i + 1) & 1)) {
                x ^= ((1 << i) | (1 << (i + 1)));
                break;
            }
        }
        System.out.println(x);
    }
}
