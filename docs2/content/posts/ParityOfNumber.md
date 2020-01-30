---
title: "Parity of a Number"
author: "Anand Rajneesh"
title: "Parity of a number"
date: "2020-01-29"
summary: "Find out the ways to calculate parity of 64 bit number"
categories: [
    "bit",
    "binary"
]
aliases: ["bit-hacks-parity"]
---
## Introduction
Parity is 1 if the number of set bits are odd else it is 0.  

## Calculating number of set bits by AND
  
```java
    // "AND" between num and num-1 will always remove rightmost set bit(bit which is 1)
    public static int parityByAndWithLesserNumber(long num) {
        int total = 0;
        while (num != 0) {
            total++;
            num = num & (num - 1);
        }
        return total & 1 ;
    }
```

## Caching for lower order numbers

```java
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
```