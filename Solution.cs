
using System;

public class Solution
{
    public int[] FindThePrefixCommonArray(int[] firstInput, int[] secondInput)
    {
        int numberOfElements = firstInput.Length;
        int[] prefixCommonArray = new int[numberOfElements];

        long bitStampOccurenceOfElementsInFirstInput = 0;
        long bitStampOccurenceOfElementsInSecondInput = 0;

        for (int i = 0; i < numberOfElements; ++i)
        {
            bitStampOccurenceOfElementsInFirstInput ^= 1L << firstInput[i];
            bitStampOccurenceOfElementsInSecondInput ^= 1L << secondInput[i];

            long overlaps = bitStampOccurenceOfElementsInFirstInput & bitStampOccurenceOfElementsInSecondInput;
            prefixCommonArray[i] = countNumberOfBitsSetToOne(overlaps);
        }
        return prefixCommonArray;
    }

    private int countNumberOfBitsSetToOne(long value)
    {
        long numberOfBitsSetToOne = 0;
        while (value > 0)
        {
            numberOfBitsSetToOne += value & 1;
            value >>= 1;
        }
        return (int)numberOfBitsSetToOne;
    }
}
