package org.gluecoders.algorithms.bit;

public class LSB {

    public static void main(String[] args) {
        System.out.println(lowestSetBitPosition(32));
    }

    public static int lowestSetBitPosition(long x) {
        long[] powerOfTwos = PowersOfTwo.getPowerOfTwos();
        long lowestSetBitNumber = lowestSetBitNumber(x);
        for (int i = 0; i < powerOfTwos.length; i++) {
            if (powerOfTwos[i] == lowestSetBitNumber) {
                return i;
            }
        }
        return -1;
    }

    public static long lowestSetBitNumber(long num) {
        return num ^ (num & (num - 1));
    }
}
