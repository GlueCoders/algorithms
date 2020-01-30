---
title: "Bit Hacks"
author: "Anand Rajneesh"
title: "Bit Hacks"
date: "2020-01-29"
summary: "How XOR and bit shifting can solve most of the bit problems"
categories: [
    "bit",
    "binary"
]
aliases: ["bit-hacks"]
---
## Introduction  
Since binary consists of only 1s and 0s, most operations can be done by flipping bits through XOR(^) operation. Applying XOR on two bits yields 1 only if both the bits are different.   


## Swapping bits at given positions  
To swap bits at given positions, we will first see whether the bits are even different. If the bits are different then we can just XOR with a bitmask to flip them essentially swapping the bits as a result.
```java
    public static long swapBits(long num, int i, int j) {
        if (((num >> i) & 1) != ((num >> j) & 1)) {
            long bitMask = (1 << i) | (1 << j);
            num ^= bitMask;
        }
        return num;
    }
```  

This technique can also be used to reverse the bits of a given number.  
```java
    private static void reverseBits(long num) {
        int j = (int) (Math.log(num) / Math.log(2));
        for (int i = 0; i < (j+1)/2; i++) {
            num = swapBits(num, i, j - i);
        }
    }
```  

## Finding position of rightmost bit set / least significant bit set
First we apply AND operation on num and (num-1). Since the least significant bit is different, applying AND will unset the least significant bit from num.  
Afterwards XORing the AND result with original num will cancel all the 1s except for the rightmost one since that was not set in AND result.

```java
    public static long lowestSetBitNumber(long num) {
        return num ^ (num & (num - 1));
    }
```