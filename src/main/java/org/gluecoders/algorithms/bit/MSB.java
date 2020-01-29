package org.gluecoders.algorithms.bit;

public class MSB {

    public static void main(String[] args) {
        long x = 13;
        long msbNumber = Long.highestOneBit(x);
        long[] powerOfTwos = PowersOfTwo.getPowerOfTwos();
        for(int i = 0 ; i < powerOfTwos.length ; i++){
            if(powerOfTwos[i] == msbNumber){
                System.out.println(i);
                break;
            }
        }
    }
}
